package com.example.projectoangel.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("actividades/")
    fun getActividades(): Response<ActividadesResponse>
}