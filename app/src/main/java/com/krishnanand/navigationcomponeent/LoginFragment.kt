package com.krishnanand.navigationcomponeent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment: Fragment(R.layout.fragment_login) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_confirm.setOnClickListener {
            val username = edit_username.text.toString()
            val password = edit_password.text.toString()
            // Rebuild project before initialising this. Needs Safe Args
            val welcomeDirection: NavDirections =
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(username, password)
            findNavController().navigate(welcomeDirection)
        }

    }
}