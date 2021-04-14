package com.krishnanand.navigationcomponeent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.krishnanand.navigationcomponeent.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment: Fragment() {

    private val args: WelcomeFragmentArgs by navArgs()

    lateinit var welcomeFragmentBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        welcomeFragmentBinding = FragmentWelcomeBinding.inflate(inflater, container, false)
        welcomeFragmentBinding.password = args.password
        welcomeFragmentBinding.username = args.username
        return welcomeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_ok.setOnClickListener {
           val directions: NavDirections = WelcomeFragmentDirections.actionWelcomeFragmentToMainFragment()
            findNavController().navigate(directions)
        }
    }
}