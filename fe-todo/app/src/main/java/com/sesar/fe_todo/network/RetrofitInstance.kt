package com.sesar.fe_todo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Use 10.0.2.2 to refer to localhost on the host machine from the Android emulator
//    private const val BASE_URL = "http://10.0.2.2:8080/api/"
    private const val BASE_URL = "http://192.168.1.12:8080/api/"

    val api: TodoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApiService::class.java)
    }
}