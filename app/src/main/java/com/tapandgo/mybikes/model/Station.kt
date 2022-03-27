package com.tapandgo.mybikes.model

data class Station (
    val number: Int,
    val name: String,
    val address: String,
    val position: GeoPosition,
    val status: String,
    val available_bikes: Int,
    val available_bike_stands: Int,
) {

    class GeoPosition(
        val lat: Float,
        val lng: Float,
    )
}