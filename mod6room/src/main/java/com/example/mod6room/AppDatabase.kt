package com.example.mod6room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Music::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun musicDao() : MusicDao
    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context, AppDatabase::class.java, "YourDatabaseName.db"
                ).fallbackToDestructiveMigration(false).build()
                INSTANCE = instance
            }
            return instance
        }
    }
}