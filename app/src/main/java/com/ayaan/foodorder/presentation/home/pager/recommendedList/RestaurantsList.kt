package com.ayaan.foodorder.presentation.home.pager.recommendedList

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
fun RecommededRestaurantsList() {
    val restaurants = listOf(
        RestaurantInfo(
            name = "Pizza Palace",
            rating = 4.8f,
            reviewCount = "2.5k",
            priceLevel = "$$",
            deliveryTime = "25-35 min",
            distance = "1.2 km",
            imageResId = R.drawable.pizza
        ),
        RestaurantInfo(
            name = "Burger House",
            rating = 4.6f,
            reviewCount = "1.8k",
            priceLevel = "$",
            deliveryTime = "15-25 min",
            distance = "0.8 km",
            imageResId = R.drawable.burger
        ),
        RestaurantInfo(
            name = "Fusion Bowl",
            rating = 4.9f,
            reviewCount = "1.7k",
            priceLevel = "$$",
            deliveryTime = "20-30 min",
            distance = "1.4 km",
            imageResId = R.drawable.fusion
        ),
        RestaurantInfo(
            name = "Urban Greens",
            rating = 4.8f,
            reviewCount = "1.5k",
            priceLevel = "$$",
            deliveryTime = "15-25 min",
            distance = "0.7 km",
            imageResId = R.drawable.greens
        ),
        RestaurantInfo(
            name = "Umami Street",
            rating = 4.9f,
            reviewCount = "3.1k",
            priceLevel = "$$",
            deliveryTime = "25-35 min",
            distance = "1.8 km",
            imageResId = R.drawable.umami
        ),
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