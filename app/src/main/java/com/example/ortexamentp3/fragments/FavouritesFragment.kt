package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ortexamentp3.R
import com.example.ortexamentp3.adapter.CharacterAdapter
import com.example.ortexamentp3.domain.models.FavouriteCharacter
import com.example.ortexamentp3.domain.repositories.AppRepository
import com.example.ortexamentp3.services.APIServices.APIResponses.Character.CharacterListResponse
import com.example.ortexamentp3.services.APIServices.RetrofitClientBuilder
import com.example.ortexamentp3.services.APIServices.RetrofitContracts.RetrofitCharacterList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavouritesFragment : Fragment() {
    private var userId : Long? = null
    private lateinit var appRepository: AppRepository
    private lateinit var favouriteCharacters : List<FavouriteCharacter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userId = arguments?.getLong("userId")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onStart() {
        super.onStart()

        val retrofitClient = RetrofitClientBuilder.buildService(RetrofitCharacterList::class.java)
        val favCharactersByUser = appRepository.getAllFavCharsByUser(userId!!.toInt())


    }
}