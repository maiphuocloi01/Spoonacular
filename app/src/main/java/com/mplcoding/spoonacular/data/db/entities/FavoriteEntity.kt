package com.mplcoding.spoonacular.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mplcoding.spoonacular.models.Result
import com.mplcoding.spoonacular.utils.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
) {
}