package com.example.ortexamentp3.domain.repositories

import android.content.Context
import androidx.room.Room
import com.example.ortexamentp3.domain.dao.UserDao
import com.example.ortexamentp3.domain.database.AppDatabase
import com.example.ortexamentp3.domain.models.User

class UserRepository private constructor(private val appDatabase: AppDatabase) {

    private val userDao : UserDao = appDatabase.userDao()

    fun addUser(user: User) : Long{
        val uId = userDao.insert(user)
        return uId
    }

     fun removeUser(user: User){
        userDao.delete(user)
    }

    fun getAllUsers() : List<User>{
        return userDao.getAll()
    }

    companion object{
        private var userRepository: UserRepository? = null

        fun getInstance(context: Context) : UserRepository{
            return userRepository ?: kotlin.run{

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDatabase"
                ).allowMainThreadQueries().build()

                val createdUserRepository = UserRepository(db)
                userRepository = UserRepository(db)
                createdUserRepository
            }
        }
    }
}