package com.sidrakotlin.retrofitwithmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sidrakotlin.retrofitwithmvvm.api.ApiInterface
import com.sidrakotlin.retrofitwithmvvm.model.Posts
import com.sidrakotlin.retrofitwithmvvm.model.PostsItem

class PostsRepository(private val apiInterface:ApiInterface) {
    private val postsLiveData = MutableLiveData<Posts>()
    val postsLv:LiveData<Posts>
    get()=postsLiveData

    suspend fun getPosts()
    {
        val result = apiInterface.getPosts()
        if(result.body()!=null)
        {
            postsLiveData.postValue(result.body())
        }

    }
}