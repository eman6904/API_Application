package com.example.api_application.model

data class Post(
    val userId: Byte,
    val id: Byte,
    val title: String,
    val body: String,
)