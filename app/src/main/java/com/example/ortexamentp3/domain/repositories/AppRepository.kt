package com.example.ortexamentp3.domain.repositories

import android.content.Context
import androidx.room.Room
import com.example.ortexamentp3.domain.dao.FavouriteCharacterDao
import com.example.ortexamentp3.domain.dao.UserDao
import com.example.ortexamentp3.domain.database.AppDatabase
import com.example.ortexamentp3.domain.models.FavouriteCharacter
import com.example.ortexamentp3.domain.models.User

class AppRepository private constructor(private val appDatabase: AppDatabase) {

    private val userDao : UserDao = appDatabase.userDao()
    private val favCharDao : FavouriteCharacterDao = appDatabase.favCharDao()

    fun addUser(user: User) : Long{
        val uId = userDao.insert(user)
        return uId
    }

    fun getUserById(userId : Int) : User{
        return userDao.GetUserById(userId)
    }

     fun removeUser(user: User){
        userDao.delete(user)
    }

    fun getAllFavCharsByUser(userId: Int) : List<FavouriteCharacter>{
        return favCharDao.getFavCharacters(userId)
    }

    fun getAllUsers() : List<User>{
        return userDao.getAll()
    }

    fun getByUserNameAndPassword(userName : String, password : String) : User{
        return userDao.findByName(userName, password)
    }

    fun getFavCharsIdsByUserId(userId : Int) : Array<Int>{
        return favCharDao.getFavCharacterIdsByUserId(userId)
    }

    fun insertFavouriteCharacter(favouriteCharacter : FavouriteCharacter) : Long{
        return favCharDao.insertFavChar(favouriteCharacter)
    }

    fun deleteFavouriteCharacter(favouriteCharacter: FavouriteCharacter){
        favCharDao.deleteFavChar(favouriteCharacter)
    }

    companion object{
        private var userRepository: AppRepository? = null

        fun getInstance(context: Context) : AppRepository{
            return userRepository ?: kotlin.run{

                val db = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appDatabase"
                ).allowMainThreadQueries().build()

                val createdUserRepository = AppRepository(db)
                userRepository = AppRepository(db)
                createdUserRepository
            }
        }
    }
}