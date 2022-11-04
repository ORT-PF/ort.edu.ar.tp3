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

class DetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val textViewStatus  = view.findViewById<TextView>(R.id.textViewDetailStatus)
        val textViewName    = view.findViewById<TextView>(R.id.textViewDetailName)
        val textViewSpecies = view.findViewById<TextView>(R.id.textViewDetailSpecies)
        val textViewOrigin  = view.findViewById<TextView>(R.id.textViewDetailOrigin)
        val buttonAddToFav  = view.findViewById<Button>(R.id.buttonAddToFavorites)

        textViewStatus.text  = DetailFragmentArgs.fromBundle(requireArguments()).character.status
        textViewName.text    = DetailFragmentArgs.fromBundle(requireArguments()).character.name
        textViewSpecies.text = "Especie: " + DetailFragmentArgs.fromBundle(requireArguments()).character.species
        textViewOrigin.text  = "Origen: "  + DetailFragmentArgs.fromBundle(requireArguments()).character.origin.name

        val imgUrl = DetailFragmentArgs.fromBundle(requireArguments()).character.image
        val characterImage = view.findViewById<ImageView>(R.id.characterDetail_image)

        Glide.with(view)
            .load(imgUrl)
            .into(characterImage)

          buttonAddToFav.setOnClickListener {
            val actionBack = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
            view.findNavController().navigate((actionBack))
        }
    }


}
