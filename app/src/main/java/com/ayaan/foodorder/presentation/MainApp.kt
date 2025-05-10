package com.ayaan.foodorder.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ayaan.foodorder.presentation.components.DeliveryLocationHeader
import com.ayaan.foodorder.presentation.components.navigation.BottomNavigation
import com.ayaan.foodorder.presentation.components.SearchBar
import com.ayaan.foodorder.presentation.home.pager.CategoryTabs
import com.ayaan.foodorder.presentation.home.FoodCategories

@Composable
fun MainApp() {
    val selectedTabIndex = remember { mutableIntStateOf(0) }
    val selectedNavItem = remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigation(selectedNavItem)
        },
        containerColor = Color.White
        ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .navigationBarsPadding()
        ) {
            DeliveryLocationHeader()
            Spacer(modifier = Modifier.height(2.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(2.dp))
            FoodCategories()
            Spacer(modifier = Modifier.height(1.dp))
            CategoryTabs(selectedTabIndex)
        }
    }
}

