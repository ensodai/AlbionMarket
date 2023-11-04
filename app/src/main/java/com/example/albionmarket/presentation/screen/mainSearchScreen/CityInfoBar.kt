package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albionmarket.data.database.LocationsData

@Composable
fun CityInfoBar(loadingState: Boolean) {
    if (loadingState){
        LinearProgressIndicator()
    }else{
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val citiesList = enumValues<LocationsData>().toList()

            for (city in citiesList) {
                val cityColorCode = enumValues<LocationsData>()
                    .first { it.nameCity == city.nameCity }.color

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 4.dp, end = 2.dp, start = 4.dp)
                        .size(7.dp)
                        .clip(CircleShape)
                        .background(cityColorCode)
                )
                Text(
                    text = city.nameCity,
                    fontSize = 10.sp
                )
            }
        }
    }

}