package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment: Fragment() {

    private lateinit var binding: WelcomeFragmentBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        binding.buttonInstructions.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            )
        )

        // disable the back button
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {}
        return binding.root
    }
}