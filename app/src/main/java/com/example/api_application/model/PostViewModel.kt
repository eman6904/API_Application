package com.example.api_application.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class PostViewModel : ViewModel() {
    val mutableLiveData = MutableLiveData<List<Post>>()
    fun getData(): LiveData<List<Post>> {
        PostClient().getPosts()
            .enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    mutableLiveData.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                }
            })
        return mutableLiveData
    }

}