package com.example.ortexamentp3.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ortexamentp3.domain.dao.FavouriteCharacterDao
import com.example.ortexamentp3.domain.dao.UserDao
import com.example.ortexamentp3.domain.models.FavouriteCharacter
import com.example.ortexamentp3.domain.models.User

@Database(entities = [User::class, FavouriteCharacter::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun favCharDao(): FavouriteCharacterDao
}
