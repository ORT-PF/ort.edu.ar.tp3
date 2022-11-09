package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.ortexamentp3.R
import com.example.ortexamentp3.activities.MainActivity
import com.example.ortexamentp3.activities.MainActivity.Companion.getQuitarBoton
import com.example.ortexamentp3.domain.models.FavouriteCharacter
import com.example.ortexamentp3.domain.repositories.AppRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFragment : Fragment() {
    private var userId : Long? = null
    private lateinit var appRepository: AppRepository
    private lateinit var vista : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        appRepository = AppRepository.getInstance(requireContext())
        // Inflate the layout for this fragment
        (activity as MainActivity?)!!.hideMenu()

        vista = inflater.inflate(R.layout.fragment_detail, container, false)
        return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = DetailFragmentArgs.fromBundle(requireArguments()).character

        val textViewStatus  = view.findViewById<TextView>(R.id.textViewDetailStatus)
        val textViewName    = view.findViewById<TextView>(R.id.textViewDetailName)
        val textViewSpecies = view.findViewById<TextView>(R.id.textViewDetailSpecies)
        val textViewOrigin  = view.findViewById<TextView>(R.id.textViewDetailOrigin)
        val buttonAddToFav  = view.findViewById<FloatingActionButton>(R.id.btnAddToFavourite)
        val backButton  = view.findViewById<Button>(R.id.backToHomeFragment)

        textViewStatus.text  = character.status
        textViewName.text    = character.name
        textViewSpecies.text = "Especie: " + character.species
        textViewOrigin.text  = "Origen: "  + character.origin.name

        val imgUrl = character.image
        val characterImage = view.findViewById<ImageView>(R.id.characterDetail_image)

        userId = MainActivity.getCurrentUserId()

        Glide.with(view)
            .load(imgUrl)
            .into(characterImage)

            buttonAddToFav.setOnClickListener {
                val favCharId = appRepository.insertFavouriteCharacter(FavouriteCharacter(0, userId!!.toInt(), character.id!!.toInt()))
                navigateToHomeFragment()

            }
        if (getQuitarBoton()) {
            buttonAddToFav.visibility = View.GONE
        }



        backButton.setOnClickListener{
            navigateToHomeFragment()
        }


    }

    override fun onStart() {
        super.onStart()


    }

    private fun navigateToHomeFragment(){
        val actionBack = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
        vista.findNavController().navigate((actionBack))
    }

    override fun onDestroyView() {
        super.onDestroyView()

        (activity as MainActivity?)!!.showMenu()
    }
}
