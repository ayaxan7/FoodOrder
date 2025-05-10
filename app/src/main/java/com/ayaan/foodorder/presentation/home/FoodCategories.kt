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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.foodorder.R
import com.ayaan.foodorder.data.FoodCategory
import com.ayaan.foodorder.ui.theme.GoodBlue

@Composable
fun FoodCategories() {
    val initialCategories = listOf(
        FoodCategory("Pizza", R.drawable.pizza, true),
        FoodCategory("Burger", R.drawable.ic_burger, false),
        FoodCategory("Coffee", R.drawable.ic_coffee, false),
        FoodCategory("Chicken", R.drawable.butterchicken, false)
    )

    // Mutable state list to track which category is selected
    val categories = remember {
        mutableStateListOf(*initialCategories.toTypedArray())
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
            .padding(bottom = 16.dp,top=16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
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
                .clip(RoundedCornerShape(24.dp))
                .background(
                    if (category.isSelected) GoodBlue else Color.LightGray.copy(alpha = 0.3f)
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = category.iconResId),
                contentDescription = category.name,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = category.name,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}