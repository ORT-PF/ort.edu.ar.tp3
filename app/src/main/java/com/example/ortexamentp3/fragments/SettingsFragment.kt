package com.example.ortexamentp3.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import com.example.ortexamentp3.R
import com.example.ortexamentp3.activities.MainActivity.Companion.verBotonFavoritos
import com.example.ortexamentp3.activities.MainActivity.Companion.verPersonajes

class SettingsFragment : Fragment() {


    lateinit var view1: View
    lateinit var buttonGoToHome: Button
    lateinit var nightMode: Switch
    lateinit var sacarFondo: Switch
    lateinit var fondoSettings: ImageView
    lateinit var quitarPersonajes: Switch



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view1 = inflater.inflate(R.layout.fragment_settings, container, false)
        buttonGoToHome = view1.findViewById(R.id.backButton)
        nightMode = view1.findViewById(R.id.night_mode)
        sacarFondo = view1.findViewById(R.id.sacar_boton_favoritos)
        fondoSettings = view1.findViewById(R.id.imagen_settings)
        quitarPersonajes = view1.findViewById(R.id.quitar_personajes)



        return view1
    }

    override fun onStart() {
        super.onStart()

        buttonGoToHome.setOnClickListener {
            view1.findNavController().navigate(R.id.action_settingsFragment2_to_homeFragment)
        }


        nightMode.setOnCheckedChangeListener { _, _ ->
            if (nightMode.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        sacarFondo.setOnCheckedChangeListener { _, _ ->
            verBotonFavoritos = !sacarFondo.isChecked
        }

        quitarPersonajes.setOnCheckedChangeListener{_,_ ->
            verPersonajes = !quitarPersonajes.isChecked
        }


    }



}
