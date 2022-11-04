package com.example.ortexamentp3.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.ortexamentp3.domain.models.FavouriteCharacter
import com.example.ortexamentp3.domain.models.User

@Dao
interface FavouriteCharacterDao {

    @Query("SELECT Favouritecharacter.characterId FROM Favouritecharacter WHERE uid = :userId")
    fun getFavCharacterIdsByUserId(userId : Int) : Array<Int>

    @Insert(entity = FavouriteCharacter::class)
    fun insertFavChar(favChar: FavouriteCharacter) : Long

    @Delete
    fun deleteFavChar(favChar: FavouriteCharacter)
}