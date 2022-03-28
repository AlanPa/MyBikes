package com.tapandgo.mybikes.repository

import com.tapandgo.mybikes.BuildConfig
import com.tapandgo.mybikes.model.Station
import com.tapandgo.mybikes.network.MyBikesService

class MyBikesRepository(
    private val service: MyBikesService,
) {
    suspend fun getStations(): List<Station> =
        service.getStations("Nantes", BuildConfig.JCDECAUX_API_KEY)

    suspend fun getStationInfo(stationNumber: Int): Station =
        service.getStationInfo(stationNumber, "Nantes", BuildConfig.JCDECAUX_API_KEY)
}