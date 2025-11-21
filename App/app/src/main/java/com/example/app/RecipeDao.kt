package com.example.app
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

class RecipeDao {



    @Dao
    interface RecipeDao {

        @Insert
        suspend fun insert(recipe: Recipe)

        @Query("SELECT * FROM recipes ORDER BY id DESC")
        suspend fun getAllRecipes(): List<Recipe>

        @Query("SELECT * FROM recipes WHERE category = :category ORDER BY id DESC")
        suspend fun getRecipesByCategory(category: String): List<Recipe>

        @Query("SELECT DISTINCT category FROM recipes")
        suspend fun getAllCategories(): List<String>
    }
}