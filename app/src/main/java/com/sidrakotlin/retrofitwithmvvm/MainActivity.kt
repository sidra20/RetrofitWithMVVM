package com.sidrakotlin.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidrakotlin.retrofitwithmvvm.adapter.PostsAdapter
import com.sidrakotlin.retrofitwithmvvm.databinding.ActivityMainBinding
import com.sidrakotlin.retrofitwithmvvm.viewmodel.PostsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostsViewModel
    private lateinit var adapter: PostsAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel=ViewModelProvider(this).get(PostsViewModel::class.java)
        binding.recyclerPosts.layoutManager=LinearLayoutManager(this)

        adapter= PostsAdapter()
        binding.recyclerPosts.adapter=adapter

        viewModel.postsLiveData.observe(this,{

            //binding.progress.visibility= View.GONE

            adapter.updateList(it)
            Log.d("Hello", "onCreate: ${it} \n")
        })
    }
}