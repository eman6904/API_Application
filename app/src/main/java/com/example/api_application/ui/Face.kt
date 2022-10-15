package com.example.api_application.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.api_application.MainActivity
import com.example.api_application.R
import com.example.api_application.databinding.FaceBinding
import com.example.api_application.model.Post
import com.example.api_application.model.PostInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Face : Fragment(R.layout.face) {
    private lateinit var binding: FaceBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FaceBinding.bind(view)
        navController = Navigation.findNavController(view)

        //to hide action bar
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(R.id.action_data_to_interface1)

        }, 2000)

    }
}