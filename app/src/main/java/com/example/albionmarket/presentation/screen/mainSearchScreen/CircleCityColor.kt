package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.database.LocationsData

@Composable
fun CircleCityColor(city: String) {
    val cityColorCode = enumValues<LocationsData>()
        .first { it.nameCity == city }.color
    Box(
        modifier = Modifier
            .padding(top = 6.dp, end = 4.dp)
            .size(11.dp)
            .clip(CircleShape)
            .background(cityColorCode)

    )
}