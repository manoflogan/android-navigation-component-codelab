package com.krishnanand.navigationcomponeent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(R.layout.fragment_main) {

    /**
     * Uses navigation componentt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_login.setOnClickListener {
            val action: NavDirections = MainFragmentDirections.actionMainFragmentToLoginFragment()
            findNavController().navigate(action)
        }
    }
}