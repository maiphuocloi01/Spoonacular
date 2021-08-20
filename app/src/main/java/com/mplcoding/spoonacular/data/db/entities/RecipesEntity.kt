package com.mplcoding.spoonacular.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mplcoding.spoonacular.models.FoodRecipe
import com.mplcoding.spoonacular.utils.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity (
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}