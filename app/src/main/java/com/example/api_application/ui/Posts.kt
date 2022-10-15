package com.example.api_application.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_application.MainActivity
import com.example.api_application.R
import com.example.api_application.databinding.PostsBinding
import com.example.api_application.model.Post
import com.example.api_application.model.PostAdapter
import com.example.api_application.model.PostViewModel
import kotlinx.coroutines.launch


class Posts : Fragment(R.layout.posts) {
    private lateinit var binding: PostsBinding
    private lateinit var navController: NavController
    private val viewModel = PostViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = PostsBinding.bind(view)
        navController = Navigation.findNavController(view)

        //to hide action bar
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()

        lifecycleScope.launch {
            viewModel.getData()
                .observe(viewLifecycleOwner, Observer { post ->
                    val adapter = PostAdapter(post)
                    binding.recycler.layoutManager = LinearLayoutManager(requireContext())
                    binding.recycler.adapter = adapter
                })
        }
    }
}