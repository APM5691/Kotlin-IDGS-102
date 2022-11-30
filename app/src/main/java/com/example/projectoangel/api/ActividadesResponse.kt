package com.example.projectoangel.api

import com.google.gson.annotations.SerializedName

data class ActividadesResponse(
    @SerializedName("success") var success:String,
    @SerializedName("response")var response:List<String>
    )