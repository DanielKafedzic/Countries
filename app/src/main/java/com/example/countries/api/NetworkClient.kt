package com.example.countries.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.example.Country

class NetworkClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://restcountries.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIService::class.java)

    fun getCountries(): Call<ArrayList<Country>> {
        return retrofit.getCountries()
    }
}