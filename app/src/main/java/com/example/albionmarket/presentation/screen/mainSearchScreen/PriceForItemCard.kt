package com.example.albionmarket.presentation.screen.mainSearchScreen

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.albionmarket.data.database.AlbionItemWithPrices

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PriceForItemCard(prices: AlbionItemWithPrices?) {
    val priceForCities = filteredPrice(prices)
    FlowRow(
        modifier = Modifier
            .padding(top = 1.dp, bottom = 5.dp)
    ) {
        for ((city, prices) in priceForCities) {
            Card(
                modifier = Modifier
                    .padding(start = 3.dp, end = 3.dp, top = 3.dp)
            )
            {
                Row(
                    modifier = Modifier.padding(all = 3.dp)
                ) {
                    CircleCityColor(city)
                    Text(text = prices.toString())
                }
            }
        }
    }
}