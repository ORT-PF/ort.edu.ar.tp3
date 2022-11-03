package com.example.ortexamentp3.services.APIServices.RetrofitContracts

import com.example.ortexamentp3.Character.CharacterListResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitCharacterList {
    @GET("/api/character")
    fun getCharacters () : Call<CharacterListResponse>
}