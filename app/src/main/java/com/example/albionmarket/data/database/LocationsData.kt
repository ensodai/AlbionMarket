package com.example.albionmarket.data.database

import androidx.compose.ui.graphics.Color


enum class LocationsData{
    Bridgewatch {
        override val code = "2004"
        override val nameCity: String = "Bridgewatch"
        override val color = Color(android.graphics.Color.parseColor("#f76397"))
    },
    Caerleon {
        override val code = "3005"
        override val nameCity: String = "Caerleon"
        override val color = Color(android.graphics.Color.parseColor("#343a40"))
    },
    FortSterling {
        override val code = "4002"
        override val nameCity: String = "Fort Sterling"
        override val color = Color(android.graphics.Color.parseColor("#00b19d"))
    },
    Lymhurst {
        override val code = "1002"
        override val nameCity: String = "Lymhurst"
        override val color= Color(android.graphics.Color.parseColor("#ffaa00"))
    },
    Martlock {
        override val code = "3008"
        override val nameCity: String = "Martlock"
        override val color = Color(android.graphics.Color.parseColor("#7266ba"))
    },
    Thetford {
        override val code = "0007"
        override val nameCity: String = "Thetford"
        override val color = Color(android.graphics.Color.parseColor("#3bafda"))
    };

    abstract val code: String
    abstract val nameCity: String
    abstract val color:  Color
}