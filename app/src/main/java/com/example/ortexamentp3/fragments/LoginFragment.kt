package com.example.ortexamentp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.ortexamentp3.R
import com.example.ortexamentp3.domain.models.User
import com.example.ortexamentp3.domain.repositories.AppRepository

class LoginFragment : Fragment() {
    private lateinit var vista : View
    private lateinit var userText : EditText
    private lateinit var passwordText : EditText
    private lateinit var loginButton : Button
    private lateinit var userRepository: AppRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        userText = vista.findViewById(R.id.loginFragmentUserText)
        passwordText = vista.findViewById(R.id.loginFragmentPasswordText)
        loginButton = vista.findViewById(R.id.loginFragmentbutton)

        return vista
    }

    override fun onStart() {
        super.onStart()

        userRepository = AppRepository.getInstance(requireContext())

        loginButton.setOnClickListener{
            val userName = userText.text.toString()
            val userPassword = userText.text.toString()

            val userId = userRepository.addUser(User(0, userName, userPassword))

            val action = LoginFragmentDirections.actionLoginFragmentToHomeFragment()
            vista.findNavController().navigate(action)
        }
    }
}