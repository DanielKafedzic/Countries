package com.example.countries.api

import com.example.example.Country
import retrofit2.Call
import retrofit2.http.GET


interface APIService {
    @GET("/v3.1/all")
    fun getCountries(): Call<ArrayList<Country>>
}