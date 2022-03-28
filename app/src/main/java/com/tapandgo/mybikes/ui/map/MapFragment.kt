package com.tapandgo.mybikes.ui.map

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tapandgo.mybikes.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val mapViewModel = ViewModelProvider(this)[MapViewModel::class.java]
        mapViewModel.stationList.observe(viewLifecycleOwner) { list ->
             list.forEach { station ->
                 val pos = LatLng(station.position.lat, station.position.lng)
                 val marker = googleMap.addMarker(MarkerOptions().position(pos).title(station.name))
                 marker?.tag = station.number
            }
            val nantes = LatLng(47.20, -1.54)
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(nantes))
            googleMap.setOnMarkerClickListener { marker ->
                marker.tag?.let { tag ->
                    val action = MapFragmentDirections.actionMapFragmentToNavigationMoreInfo(tag as Int)
                    findNavController().navigate(action)
                }
                true
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}