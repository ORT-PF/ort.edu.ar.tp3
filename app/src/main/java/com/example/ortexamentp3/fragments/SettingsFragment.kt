package com.example.ortexamentp3.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import com.example.ortexamentp3.R
import com.example.ortexamentp3.activities.MainActivity
import com.example.ortexamentp3.activities.MainActivity.Companion.setVerPersonajes

class SettingsFragment : Fragment() {


    lateinit var view1: View
    lateinit var buttonGoToHome: Button
    lateinit var nightMode: Switch
    lateinit var quitarPersonajes: Switch


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_settings, container, false)


        buttonGoToHome = view1.findViewById(R.id.backButton)
        nightMode = view1.findViewById(R.id.night_mode)
        quitarPersonajes = view1.findViewById(R.id.ver_personajes)

        (activity as MainActivity?)!!.hideMenu()

        buttonGoToHome.setOnClickListener {

            var action = SettingsFragmentDirections.actionSettingsFragmentToHomeFragment();
            view1.findNavController().navigate(action)

        }

        return view1
    }

    override fun onStart() {
        super.onStart()




        nightMode.setOnCheckedChangeListener { _, _ ->
            if (nightMode.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        quitarPersonajes.setOnCheckedChangeListener { _, _ ->
            if (quitarPersonajes.isChecked){
                setVerPersonajes(false)
            }else{
                setVerPersonajes(true)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        (activity as MainActivity?)!!.showMenu()
    }



}
