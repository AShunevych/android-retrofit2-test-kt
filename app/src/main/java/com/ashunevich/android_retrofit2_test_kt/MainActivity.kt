package com.ashunevich.android_retrofit2_test_kt

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ashunevich.android_retrofit2_test_kt.databinding.ActivityMainBinding
import com.ashunevich.android_retrofit2_test_kt.di.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var adapterJson: JsonRecyclerViewAdapter? = null

    @Inject lateinit var webApi: WebApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        DiApp.component.inject(this)

        setupRecyclerView()
        binding!!.getButton.setOnClickListener { injectRetrofit() }
    }

    fun setupRecyclerView(){
        adapterJson = JsonRecyclerViewAdapter()
        binding?.recView?.layoutManager = LinearLayoutManager(this)
        binding?.recView?.adapter = adapterJson
    }

    private fun injectRetrofit(){
        val call: Call<MutableList<ItemJSON>> = webApi.getPosts()
        call.enqueue(object :Callback<MutableList<ItemJSON>>{
            override fun onResponse(
                call: Call<MutableList<ItemJSON>>,
                response: Response<MutableList<ItemJSON>>
            ) {
                response.body()?.let { adapterJson!!.swap(it) }
                Log.d("OPERATION @GET", "CALLBACK +")
            }
            override fun onFailure(call: Call<MutableList<ItemJSON>>, t: Throwable) {
                Log.d("OPERATION @GET", "CALLBACK -")
            }
        })
    }
}
