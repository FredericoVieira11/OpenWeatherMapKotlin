package com.example.openweathermapkotlin.ui.citiesList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.openweathermapkotlin.R
import com.example.openweathermapkotlin.ui.City
import com.example.openweathermapkotlin.ui.citiesList.CitiesListFragmentDirections

class CityAdapter(
        private val cities: MutableList<City>,
        private val fragment: Fragment
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CityViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_preview, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is CityViewHolder -> {
                holder.bind(cities[position])
            }
        }

        holder.itemView.setOnClickListener {
            val name = cities[position].name
            val action = CitiesListFragmentDirections.actionCitiesListFragmentToCityWeatherFragment(
                    passingName = name
            )
            findNavController(fragment).navigate(action)
        }
    }

    override fun getItemCount(): Int = cities.size
}

class CityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val imgCity = itemView.findViewById<ImageView>(R.id.imgCity)
    private val txtCityName = itemView.findViewById<TextView>(R.id.txtCityName)

    fun bind(city: City) {
        with(city) {
            txtCityName.text = name
            imgCity.setImageResource(image)
        }
    }
}