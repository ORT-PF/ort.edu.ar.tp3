package com.example.ortexamentp3.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ortexamentp3.domain.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE name LIKE :userName AND " +
            "password LIKE :userPassword LIMIT 1")
    fun findByName(userName: String, userPassword: String): User

    @Insert(entity = User::class)
    fun insert(user: User) : Long

    @Delete
    fun delete(user: User)
}