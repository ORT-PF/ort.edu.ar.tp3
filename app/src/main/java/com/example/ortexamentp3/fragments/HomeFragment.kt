package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ortexamentp3.Character.CharacterListResponse
import com.example.ortexamentp3.R
import com.example.ortexamentp3.adapter.CharacterAdapter
import com.example.ortexamentp3.listener.OnCharacterClickedListener
import com.example.ortexamentp3.services.APIServices.RetrofitClientBuilder
import com.example.ortexamentp3.services.APIServices.RetrofitContracts.RetrofitCharacterList
import com.example.ortexamentp3.viewModel.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), OnCharacterClickedListener {

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



        val retrofitClient = RetrofitClientBuilder.buildService(RetrofitCharacterList::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)



        retrofitClient.getCharacters().enqueue(object : Callback<CharacterListResponse> {
            override fun onResponse(
                call: Call<CharacterListResponse>,
                response: Response<CharacterListResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(activity, "Success Response", Toast.LENGTH_LONG).show()
                    val characterList = response.body()?.results

                    val adapter = characterList?.let { CharacterAdapter(it,this@HomeFragment)}
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = adapter

                }
            }

            override fun onFailure(call: Call<CharacterListResponse>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
                val texterror = view.findViewById<TextView>(R.id.textView)
                texterror.text = t.message
            }
        })

    }

    override fun onStart(){
        super.onStart()
    }

    override fun onProductSelected(character: Character) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(character))
    }


}