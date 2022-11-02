package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ortexamentp3.Character.CharacterListResponse
import com.example.ortexamentp3.R
import com.example.ortexamentp3.adapter.CharacterAdapter
import com.example.ortexamentp3.services.APIServices.RetrofitClientBuilder
import com.example.ortexamentp3.services.APIServices.RetrofitContracts.RetrofitCharacterList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*val char1 = Character("1","Martin","Mutante","Marte")
        val char2 = Character("2","Pepe","Humano","Tierra")
        val char3 = Character("3","Jose","Robot","Marte")
        val char4 = Character("4","Fede","Animal","Marte")

        val characters = listOf(char1,char2,char3,char4)
*/
        val retrofitClient = RetrofitClientBuilder.buildService(RetrofitCharacterList::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)


        retrofitClient.getCharacters().enqueue(object: Callback<List<CharacterListResponse>> {
            override fun onResponse(
                call: Call<List<CharacterListResponse>>,
                response: Response<List<CharacterListResponse>>
            ) {
                if (response.isSuccessful) {
                    val characterList = response.body()

                    val adapter = characterList?.let { CharacterAdapter(it) }
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter

                }
            }

            override fun onFailure(call: Call<List<CharacterListResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })

        //val adapter = CharacterAdapter(characters)
        //recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart(){
        super.onStart()
    }


}