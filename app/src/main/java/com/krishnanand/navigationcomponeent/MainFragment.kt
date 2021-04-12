package com.krishnanand.navigationcomponeent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment: Fragment() {
    lateinit var loginButton: Button

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        loginButton = view.findViewById(R.id.button_login)
        loginButton.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }
}