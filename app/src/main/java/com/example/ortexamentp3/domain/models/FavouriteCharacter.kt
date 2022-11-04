package com.example.ortexamentp3.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "FavouriteCharacter",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["uid"],
            childColumns = ["userId"],
            onDelete = CASCADE)])
data class FavouriteCharacter (
    @PrimaryKey(autoGenerate = true) val uid : Int,
    @ColumnInfo(name = "userId") val userId : Int,
    @ColumnInfo(name = "characterId") val characterId : Int)