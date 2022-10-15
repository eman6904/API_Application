package com.example.api_application.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PostClient {
    val postInterface: PostInterface

    constructor () {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        postInterface = retrofit.create(PostInterface::class.java)
    }

    fun getPosts(): retrofit2.Call<List<Post>> {
        return postInterface.getPost()
    }
}