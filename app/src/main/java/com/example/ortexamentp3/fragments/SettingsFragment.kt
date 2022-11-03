package com.example.ortexamentp3.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.ortexamentp3.R

class SettingsFragment : Fragment() {


    lateinit var view1: View
    lateinit var buttonGoToHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view1 = inflater.inflate(R.layout.fragment_settings, container, false)

        buttonGoToHome = view1.findViewById(R.id.backButton)

        return view1
    }

    override fun onStart() {
        super.onStart()

        buttonGoToHome.setOnClickListener{
            //val action = SettingsFragmentDirections.action_settingsFragment3_to_homeFragment
            view1.findNavController().navigate(R.id.action_settingsFragment_to_homeFragment)
        }
    }
}
