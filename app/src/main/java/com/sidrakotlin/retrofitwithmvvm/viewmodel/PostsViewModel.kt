package com.sidrakotlin.retrofitwithmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sidrakotlin.retrofitwithmvvm.api.ApiInterface
import com.sidrakotlin.retrofitwithmvvm.api.PostsApi
import com.sidrakotlin.retrofitwithmvvm.model.Posts
import com.sidrakotlin.retrofitwithmvvm.repository.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostsViewModel():ViewModel() {

    private val api = PostsApi.retrofitService
    private val repository: PostsRepository=PostsRepository(api)
    init{
        viewModelScope.launch (Dispatchers.IO){
            repository.getPosts()
        }
    }
    val postsLiveData :LiveData<Posts>
    get() = repository.postsLv

}