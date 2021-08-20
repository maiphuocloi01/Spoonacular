package com.mplcoding.spoonacular.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mplcoding.spoonacular.data.db.entities.FavoriteEntity
import com.mplcoding.spoonacular.utils.TypeConverter

@Database(
    entities = [RecipesEntity::class, FavoriteEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class RecipesDatabase : RoomDatabase() {
    abstract fun recipesDao(): RecipesDao
}