package com.example.ortexamentp3.services.APIServices.RetrofitContracts

import com.example.ortexamentp3.domain.viewModel.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RetrofitFavCharacterList {
    //@GET("/api/character/{id}")
    //fun getFavCharacters (@Query("id") List<Integer> ids) : Call<List<Character>>

    @GET("/api/character/{id}")
    fun getFavCharacters(@Path("id") id: ArrayList<Int>): Call<List<Character>>
}