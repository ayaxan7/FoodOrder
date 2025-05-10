package com.ayaan.foodorder.presentation.home

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.foodorder.R
import com.ayaan.foodorder.data.FoodCategory
import com.ayaan.foodorder.ui.theme.GoodBlue

@Composable
fun FoodCategories() {
    val initialCategories = listOf(
        FoodCategory("Indian", R.drawable.indian_food, true),
        FoodCategory("Italian", R.drawable.italian_food, false),
        FoodCategory("Chinese", R.drawable.chinese_food, false),
        FoodCategory("Drinks", R.drawable.drinks, false)
    )

    // Mutable state list to track which category is selected
    val categories = remember {
        mutableStateListOf(*initialCategories.toTypedArray())
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .padding(bottom = 16.dp, top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(categories) { index, category ->
            FoodCategoryItem(
                index = index,
                category = category,
                onCategoryClick = {
                    val updatedCategories = categories.mapIndexed { i, cat ->
                        cat.copy(isSelected = i == index)
                    }
                    categories.clear()
                    categories.addAll(updatedCategories)
                }
            )
        }
    }
}

@Composable
fun FoodCategoryItem(
    index: Int,
    category: FoodCategory,
    onCategoryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clickable { onCategoryClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .height(56.dp)
                .width(100.dp)
                .clip(RectangleShape)
                .background(
                   Color.Transparent
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = category.iconResId),
                contentDescription = category.name,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = category.name,
            fontSize = 12.sp,
            color = Color.Black,

        )
        if(category.isSelected) {
            HorizontalDivider(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                thickness = 3.dp,
                color = GoodBlue
            )
        }
    }
}