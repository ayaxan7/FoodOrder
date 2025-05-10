package com.ayaan.foodorder.presentation.components.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.automirrored.outlined.ListAlt
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayaan.foodorder.data.NavItem
import com.ayaan.foodorder.ui.theme.GoodBlue

@Composable
fun BottomNavigation(selectedNavItem: MutableState<Int>) {
    val navItems = listOf(
        NavItem("Home", Icons.Filled.Home),
        NavItem("Food", Icons.Filled.Fastfood),
        NavItem("Orders", Icons.AutoMirrored.Filled.ListAlt),
        NavItem("Settings", Icons.Filled.Settings)
    )

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 8.dp,
        modifier = Modifier
            .height(62.dp)
            .padding(bottom = 4.dp)
            .navigationBarsPadding()
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavItem.value == index,
                onClick = { },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selectedNavItem.value == index) GoodBlue else Color.Gray,
                        modifier = Modifier
                            .size(24.dp)
                            .noRippleClickable(onClick = { selectedNavItem.value = index })
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        fontSize = 12.sp,
                        color = if (selectedNavItem.value == index) GoodBlue else Color.Gray
                    )
                })
        }
    }
}

// Extension function to make clickable without ripple effect
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        indication = null, // This removes the ripple effect
        interactionSource = remember { MutableInteractionSource() } // Keeps track of interactions without ripples
    ) {
        onClick() // Action to be performed on click
    }
}