package com.example.api_application.model

import retrofit2.http.GET

interface PostInterface {
    @GET("posts")
    fun getPost():retrofit2.Call<List<Post>>
}