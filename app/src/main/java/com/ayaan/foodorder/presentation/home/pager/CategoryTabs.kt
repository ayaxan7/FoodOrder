package com.ayaan.foodorder.presentation.home.pager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ayaan.foodorder.presentation.home.pager.popularList.PopularContent
import com.ayaan.foodorder.presentation.home.pager.recommendedList.RecommededRestaurantsList
import com.ayaan.foodorder.ui.theme.GoodBlue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CategoryTabs(selectedTabIndex: MutableState<Int>) {
    val tabs = listOf("Recommended", "Popular")
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        if (selectedTabIndex.value != pagerState.currentPage) {
            pagerState.scrollToPage(selectedTabIndex.value)
        }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex.value]),
                    height = 2.dp,
                    color = GoodBlue
                )
            },
            divider = { HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f)) }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex.value == index,
                    onClick = {
                        selectedTabIndex.value = index
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex.value == index) GoodBlue else Color.Gray,
                            fontWeight = if (selectedTabIndex.value == index) FontWeight.Medium else FontWeight.Normal
                        )
                    }
                )
            }
        }

        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            // Update the selected tab when the pager is swiped
            if (selectedTabIndex.value != page) {
                selectedTabIndex.value = page
            }

            when (page) {
                0 -> RecommededRestaurantsList()
                1 -> PopularContent()
            }
        }
    }
}


