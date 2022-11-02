package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ortexamentp3.R
import com.example.ortexamentp3.viewModel.Character

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


        val char1 = Character("1","Martin","Mutante","Marte")
        val char2 = Character("2","Pepe","Humano","Tierra")
        val char3 = Character("3","Jose","Robot","Marte")
        val char4 = Character("4","Fede","Animal","Marte")

        val characters = listOf(char1,char2,char3,char4)
    }


}