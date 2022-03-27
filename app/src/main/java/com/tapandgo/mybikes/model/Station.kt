package com.tapandgo.mybikes.model

import com.google.android.gms.maps.model.LatLng

data class Station (
    val number: Int,
    val name: String,
    val address: String,
    val position: LatLng,
    val status: String,
    val connected: Boolean,
    val mainStands: Stand,
) {
    class Stand (
        val availabilities: StationAvailabilities
    )

    class StationAvailabilities(
        val bikes: Int,
        val stands: Int,
    )
}