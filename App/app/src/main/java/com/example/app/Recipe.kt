package com.example.app
import androidx.room.Entity
import androidx.room.PrimaryKey

class Recipe {



    @Entity(tableName = "recipes")
    data class Recipe(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        val title: String,
        val ingredients: String,
        val category: String
    )
}