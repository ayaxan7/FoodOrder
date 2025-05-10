package com.ayaan.foodorder.data

data class RestaurantInfo(
    val name: String,
    val rating: Float,
    val reviewCount: String,
    val priceLevel: String,
    val deliveryTime: String,
    val distance: String,
    val imageResId: Int
)
