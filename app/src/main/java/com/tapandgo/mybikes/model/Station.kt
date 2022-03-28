package com.tapandgo.mybikes.model

import com.squareup.moshi.Json

/**
 * Model of a bike station
 */
data class Station (
    val number: Int, // Unique Id in our case. Not true if we open the app to other contracts
    val name: String,
    val address: String,
    val position: GeoPosition,
    val status: String,
    @Json(name="available_bikes") val availableBikes: Int,
    @Json(name="available_bike_stands") val availableBikeStands: Int,
    @Json(name="last_update") val lastUpdate: Long
) {

    class GeoPosition(
        val lat: Double,
        val lng: Double,
    )
}