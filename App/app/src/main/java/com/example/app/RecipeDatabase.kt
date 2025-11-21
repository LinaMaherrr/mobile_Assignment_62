package com.example.app
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class RecipeDatabase {



    @Database(entities = [Recipe::class], version = 1)
    abstract class RecipeDatabase : RoomDatabase() {

        abstract fun recipeDao(): RecipeDao

        companion object {

            @Volatile
            private var INSTANCE: RecipeDatabase? = null

            fun getInstance(context: Context): RecipeDatabase {
                if (INSTANCE == null) {
                    synchronized(RecipeDatabase::class) {
                        if (INSTANCE == null) {
                            INSTANCE = Room.databaseBuilder(
                                context.applicationContext,
                                RecipeDatabase::class.java,
                                "recipe_db"              // database name
                            ).build()
                        }
                    }
                }
                return INSTANCE!!
            }
        }
    }
}