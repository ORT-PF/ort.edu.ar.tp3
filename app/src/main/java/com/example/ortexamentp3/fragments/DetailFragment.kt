package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
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

        val textViewName    = view.findViewById<TextView>(R.id.textViewName)
        val textViewSpecies = view.findViewById<TextView>(R.id.textViewSpecies)
        val textViewOrigin  = view.findViewById<TextView>(R.id.textViewOrigin)
        val buttonBack      = view.findViewById<Button>(R.id.buttonBack)

        textViewName.text = DetailFragmentArgs.fromBundle(requireArguments()).character.name
        textViewSpecies.text = DetailFragmentArgs.fromBundle(requireArguments()).character.especies
        textViewOrigin.text = DetailFragmentArgs.fromBundle(requireArguments()).character.origin.name

        buttonBack.setOnClickListener {
            val actionBack = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
            view.findNavController().navigate((actionBack))
        }
        }


}