package com.tapandgo.mybikes.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tapandgo.mybikes.databinding.FragmentMoreInfoBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Display information for a specific station
 */
@AndroidEntryPoint
class MoreInfoFragment : Fragment() {

    private var _binding: FragmentMoreInfoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val moreInfoViewModel =
            ViewModelProvider(this)[MoreInfoViewModel::class.java]

        _binding = FragmentMoreInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Bind each field with the model data
        val stationNameField: TextView = binding.stationNameField
        moreInfoViewModel.stationName.observe(viewLifecycleOwner) {
            stationNameField.text = it
        }
        val addressField: TextView = binding.moreInfoAddressField
        moreInfoViewModel.address.observe(viewLifecycleOwner) {
            addressField.text = it
        }
        val lastUpdateField: TextView = binding.moreInfoLastUpdateField
        moreInfoViewModel.lastUpdate.observe(viewLifecycleOwner) {
            lastUpdateField.text = it
        }
        val availableBikesField: TextView = binding.moreInfoAvailableBikesField
        moreInfoViewModel.availableBikes.observe(viewLifecycleOwner) {
            availableBikesField.text = it.toString()
        }
        val availableStandsField: TextView = binding.moreInfoAvailableStandsField
        moreInfoViewModel.availableStands.observe(viewLifecycleOwner) {
            availableStandsField.text = it.toString()
        }
        // Call the method to get data
        moreInfoViewModel.retrieveStationInfo()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}