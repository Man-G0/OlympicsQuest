package com.example.olympicsquest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ActivitiesService {
    @GET("current.json")
    suspend fun getActivities(
        //@Query("key") apiKey:String,
        @Query("q") city:String,
    ):ActivitiesResponse
}
object ActivitiesApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://data.iledefrance.fr/api/explore/v2.1/catalog/datasets/principaux-sites-touristiques-en-ile-de-france0/records/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val activitiesService:ActivitiesService= retrofit.create(ActivitiesService::class.java)
}