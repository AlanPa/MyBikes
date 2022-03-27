package com.tapandgo.mybikes.model

import com.squareup.moshi.Json

data class Station (
    val number: Int,
    val name: String,
    val address: String,
    val position: GeoPosition,
    val status: String,
    @Json(name="available_bikes") val availableBikes: Int,
    @Json(name="available_bike_stands") val availableBikeStands: Int,
) {

    class GeoPosition(
        val lat: Float,
        val lng: Float,
    )
}