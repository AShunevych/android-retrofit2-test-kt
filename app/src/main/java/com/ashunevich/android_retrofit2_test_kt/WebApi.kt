package com.ashunevich.android_retrofit2_test_kt

import retrofit2.Call
import retrofit2.http.GET

interface WebApi{

    @GET("posts")
    fun getPosts(): Call<MutableList<ItemJSON>>

    @GET("item")
    fun getSingleItem(): Call<ItemJSON>
}