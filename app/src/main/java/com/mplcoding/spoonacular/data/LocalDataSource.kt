package com.mplcoding.spoonacular.data

import com.mplcoding.spoonacular.data.db.RecipesDao
import com.mplcoding.spoonacular.data.db.RecipesEntity
import com.mplcoding.spoonacular.data.db.entities.FavoriteEntity
import com.mplcoding.spoonacular.data.db.entities.FoodJokeEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun insertFavoriteRecipes(favoriteEntity: FavoriteEntity){
        recipesDao.insertFavoriteRecipes(favoriteEntity)
    }

    suspend fun insertFoodJoke(foodJokeEntity: FoodJokeEntity) {
        recipesDao.insertFoodJoke(foodJokeEntity)
    }

    fun getRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.getRecipes()
    }

    fun getFavoriteRecipes(): Flow<List<FavoriteEntity>> {
        return recipesDao.getFavoriteRecipes()
    }

    fun getFoodJoke(): Flow<List<FoodJokeEntity>> {
        return recipesDao.getFoodJoke()
    }

    suspend fun deleteFavoriteRecipe(favoriteEntity: FavoriteEntity){
        recipesDao.deleteFavoriteRecipe(favoriteEntity)
    }

    suspend fun deleteAllFavoriteRecipes(){
        recipesDao.deleteAllFavoriteRecipes()
    }
}