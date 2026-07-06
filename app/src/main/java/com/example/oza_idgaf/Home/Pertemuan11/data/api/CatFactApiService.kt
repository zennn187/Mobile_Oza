package com.example.oza_idgaf.Home.Pertemuan11.data.api

import com.example.oza_idgaf.Home.Pertemuan11.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}