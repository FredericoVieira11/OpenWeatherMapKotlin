package com.example.openweathermapkotlin.ui

import com.example.openweathermapkotlin.R

data class City (
    val image: Int,
    val name: String
)

class CityBuilder {
    var image: Int = 0
    var name: String = ""

    fun build(): City = City(image, name)
}

fun city(block: CityBuilder.() -> Unit): City = CityBuilder().apply(block).build()

fun citiesList() = mutableListOf(
    city {
        image = R.drawable.background_lisbon
        name = "Lisbon"
    },
    city {
        image = R.drawable.background_madrid
        name = "Madrid"
    },
    city {
        image = R.drawable.background_paris
        name = "Paris"
    },
    city {
        image = R.drawable.background_berlin
        name = "Berlin"
    },
    city {
        image = R.drawable.background_copenhagen
        name = "Copenhagen"
    },
    city {
        image = R.drawable.background_rome
        name = "Rome"
    },
    city {
        image = R.drawable.background_london
        name = "London"
    },
    city {
        image = R.drawable.background_dublin
        name = "Dublin"
    },
    city {
        image = R.drawable.background_prague
        name = "Prague"
    },
    city {
        image = R.drawable.background_vienna
        name = "Vienna"
    }
)