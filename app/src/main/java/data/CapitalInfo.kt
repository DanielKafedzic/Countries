package com.example.example

import com.google.gson.annotations.SerializedName


data class CapitalInfo(

    @SerializedName("latlng" ) var latlng : ArrayList<Double> = arrayListOf()

)