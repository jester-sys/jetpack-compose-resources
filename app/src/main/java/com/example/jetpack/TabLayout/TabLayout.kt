package com.example.jetpack.TabLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class) // Accompanist Pager is experimental, so we need to opt into its usage.
@Composable
fun TabLayout() {
    val pagerState = com.google.accompanist.pager.rememberPagerState() // Holds the current state of the pager (e.g., current page).
    val scope = rememberCoroutineScope() // Used to launch coroutines for animations and state updates.

    Column(
        modifier = Modifier.fillMaxSize() // Ensures the entire column layout takes up the maximum screen space.
    ) {
        // TabRow: Displays a row of tabs at the top.
        TabRow(
            selectedTabIndex = pagerState.currentPage, // Highlights the selected tab based on the current page index.
            Modifier.background(Color.Yellow) // Sets a yellow background color for the TabRow.
        ) {
            // Iterating through the list of tabs to create each tab.
            tabList.forEachIndexed { index, tabData ->
                Tab(
                    selected = pagerState.currentPage == index, // Checks if the current tab is selected.
                    onClick = {
                        // When a tab is clicked, scroll to the corresponding page in the pager.
                        scope.launch {
                            pagerState.animateScrollToPage(index) // Smoothly scrolls to the selected page.
                        }
                    },
                    modifier = Modifier.padding(20.dp) // Adds padding around the Tab for spacing.
                ) {
                    // Displays the tab label (e.g., "Home", "Status").
                    Text(text = tabList[index].tab)
                }
            }
        }

        // HorizontalPager: Displays the content for each tab as a horizontally scrollable pager.
        HorizontalPager(
            count = tabList.size, // Total number of pages is equal to the size of the tab list.
            state = pagerState // Synchronizes the pager's state with the TabRow.
        ) { index ->
            // Displays the description corresponding to the current page.
            Text(text = tabList[index].des)
        }
    }
}

// Data class to represent a tab's label and description.
data class TabData(
    val tab: String, // The tab's label (e.g., "Home").
    val des: String  // The description or content displayed in the pager for this tab.
)

// A list of tab data to define the tabs and their respective content.
val tabList = listOf(
    TabData(
        tab = "Home", // Tab label.
        des = "This is home page" // Content displayed for the "Home" tab.
    ),
    TabData(
        tab = "Status", // Tab label.
        des = "This is Status page" // Content displayed for the "Status" tab.
    ),
    TabData(
        tab = "Call", // Tab label.
        des = "This is Call page" // Content displayed for the "Call" tab.
    )
)
