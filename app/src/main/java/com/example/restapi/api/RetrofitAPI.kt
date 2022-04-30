package com.example.restapi.api

import com.example.restapi.api.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

 interface RetrofitAPI {
    @GET("posts/title")
     fun getPosts(): Call<User>

    @GET("posts/{userId}")
    fun getPost(@Path("userId") id: String): Call<User>

    companion object {
        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun create() : RetrofitAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitAPI::class.java)
        }
    }
}