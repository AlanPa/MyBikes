package com.tapandgo.mybikes.network

import com.tapandgo.mybikes.model.Station
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyBikesService {

    @GET("stations")
    suspend fun getStations(
        @Query("contract") contractName: String,
        @Query("apiKey") apiKey: String,
    ): List<Station>

    @GET("stations/{stationNumber}")
    suspend fun getStationInfo(
        @Path("stationNumber") stationNumber: Int,
        @Query("contract") contractName: String,
        @Query("apiKey") apiKey: String,
    ): Station
}