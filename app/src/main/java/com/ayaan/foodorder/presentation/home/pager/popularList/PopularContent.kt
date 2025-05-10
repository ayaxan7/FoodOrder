package com.ayaan.foodorder.presentation.home.pager.popularList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ayaan.foodorder.R
import com.ayaan.foodorder.data.RestaurantInfo
import com.ayaan.foodorder.presentation.home.pager.common.RestaurantItem

@Composable
fun PopularContent() {
    val restaurants = listOf(
        RestaurantInfo(
            name = "Biryani Mahal",
            rating = 4.8f,
            reviewCount = "3.5k",
            priceLevel = "$",
            deliveryTime = "60-70 min",
            distance = "3.2 km",
            imageResId = R.drawable.biryani
        ),
        RestaurantInfo(
            name = "The Coffee Place",
            rating = 4.5f,
            reviewCount = "4.5k",
            priceLevel = "$$",
            deliveryTime = "10-15 min",
            distance = "0.5 km",
            imageResId = R.drawable.coffee
        ),
        RestaurantInfo(
            name = "Spice Garden",
            rating = 4.6f,
            reviewCount = "2.8k",
            priceLevel = "$$",
            deliveryTime = "40-50 min",
            distance = "2.1 km",
            imageResId = R.drawable.spice
        ),
        RestaurantInfo(
            name = "Noodle House",
            rating = 4.7f,
            reviewCount = "3.2k",
            priceLevel = "$$",
            deliveryTime = "25-35 min",
            distance = "1.7 km",
            imageResId = R.drawable.noodle
        ),
        RestaurantInfo(
            name = "Tandoori Nights",
            rating = 4.9f,
            reviewCount = "1.9k",
            priceLevel = "$$$",
            deliveryTime = "45-55 min",
            distance = "3.8 km",
            imageResId = R.drawable.tandoori
        ),
        RestaurantInfo(
            name = "Sushi Express",
            rating = 4.4f,
            reviewCount = "2.3k",
            priceLevel = "$$",
            deliveryTime = "30-40 min",
            distance = "2.5 km",
            imageResId = R.drawable.sushi
        ),
        RestaurantInfo(
            name = "Mediterranean Grill",
            rating = 4.3f,
            reviewCount = "1.5k",
            priceLevel = "$$",
            deliveryTime = "35-45 min",
            distance = "1.9 km",
            imageResId = R.drawable.mediterranean
        ),
        RestaurantInfo(
            name = "Thai Delight",
            rating = 4.7f,
            reviewCount = "3.0k",
            priceLevel = "$$$",
            deliveryTime = "40-50 min",
            distance = "2.8 km",
            imageResId = R.drawable.thai
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState(0)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        restaurants.forEach { restaurant ->
            RestaurantItem(restaurant)
        }
    }
}