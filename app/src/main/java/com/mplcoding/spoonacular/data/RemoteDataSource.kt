package com.mplcoding.spoonacular.data

import com.mplcoding.spoonacular.data.network.FoodRecipesApi
import com.mplcoding.spoonacular.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: FoodRecipesApi
) {
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return api.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe>{
        return api.searchRecipes(searchQuery)
    }
}