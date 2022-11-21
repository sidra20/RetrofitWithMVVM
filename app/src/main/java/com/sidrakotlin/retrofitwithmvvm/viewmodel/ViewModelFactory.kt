package com.sidrakotlin.retrofitwithmvvm.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.sidrakotlin.retrofitwithmvvm.repository.PostsRepository

class ViewModelFactory(private val repository: PostsRepository):ViewModelProvider.Factory {

}