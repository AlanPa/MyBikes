package com.tapandgo.mybikes.model

import com.google.android.gms.maps.model.LatLng

data class Station (
    val number: Int,
    val name: String,
    val address: String,
    val position: LatLng, // FIXME (lat and lng always 0)
    val status: String,
    //val connected: Boolean, FIXME
    //val mainStands: Stand, FIXME
) {
    class Stand (
        val availabilities: StationAvailabilities
    )

    class StationAvailabilities(
        val bikes: Int,
        val stands: Int,
    )
}