package com.example.example

import com.google.gson.annotations.SerializedName


data class Maps (

    @SerializedName("googleMaps"     ) var googleMaps     : String? = null,
    @SerializedName("openStreetMaps" ) var openStreetMaps : String? = null

)