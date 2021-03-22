package com.example.openweathermapkotlin.ui.citiesList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openweathermapkotlin.databinding.FragmentCitiesListBinding
import com.example.openweathermapkotlin.ui.citiesList
import com.example.openweathermapkotlin.ui.citiesList.adapter.CityAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesListFragment : Fragment() {

    private lateinit var binding: FragmentCitiesListBinding
    private lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val cities = citiesList()
        cityAdapter = CityAdapter(cities, this)

        binding.rvCities.apply {
            adapter = cityAdapter
            cityAdapter.notifyDataSetChanged()
            layoutManager = LinearLayoutManager(activity)
        }
    }

}