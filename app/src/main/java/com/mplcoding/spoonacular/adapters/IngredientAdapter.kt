package com.mplcoding.spoonacular.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mplcoding.spoonacular.R
import com.mplcoding.spoonacular.databinding.IngredientRowLayoutBinding
import com.mplcoding.spoonacular.models.ExtendedIngredient
import com.mplcoding.spoonacular.utils.Constants.Companion.BASE_IMAGE_URL
import com.mplcoding.spoonacular.utils.RecipesDiffUtil

class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.MyViewHolder>() {
    private var ingredientList = emptyList<ExtendedIngredient>()

    class MyViewHolder(private val binding: IngredientRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: ExtendedIngredient) {
            binding.apply {
                ingredientImageView.load(BASE_IMAGE_URL + ingredient.image) {
                    crossfade(600)
                    error(R.drawable.ic_error_placeholder)
                }
                ingredientName.text = ingredient.name.replaceFirstChar { it.uppercase() }
                ingredientAmount.text = ingredient.amount.toString()
                ingredientUnit.text = ingredient.unit
                ingredientConsistency.text = ingredient.consistency
                ingredientOriginal.text = ingredient.original
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            IngredientRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(ingredientList[position])
    }

    override fun getItemCount(): Int {
        return ingredientList.size
    }

    fun setData(newIngredient: List<ExtendedIngredient>) {
        val ingredientDiffUtil =
            RecipesDiffUtil(ingredientList, newIngredient)
        val diffUtil = DiffUtil.calculateDiff(ingredientDiffUtil)
        ingredientList = newIngredient
        diffUtil.dispatchUpdatesTo(this)
    }
}