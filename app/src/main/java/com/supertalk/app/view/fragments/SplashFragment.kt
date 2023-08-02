package com.supertalk.app.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.supertalk.R
import com.supertalk.databinding.FragmentSplashBinding
import com.supertalk.app.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {
    val viewModel: SplashViewModel by viewModels()
    lateinit var binding: FragmentSplashBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSplashBinding.bind(view)
        binding.splashViewModel = viewModel
        binding.lifecycleOwner = this



        viewModel.initSplashScreen()

        viewModel.splashlivedata.observe(viewLifecycleOwner) { isUserlistOpen ->
            if (isUserlistOpen!!) {
                redirectToUserList()
            }
        }

    }


    fun redirectToUserList() {
        println("splash successssssssssssssssss")
        findNavController().navigate(R.id.action_SplashFragment_to_HomeFragment)
    }


}