package com.example.jetpack.ViewPager

import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpack.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class) // Opt-in for using the experimental Pager API
@Composable
fun OnBoardingScreen() {
    val pageState = rememberPagerState() // Remember the state of the pager (current page)

    // Column to hold the pager and other UI elements
    Column {
        // HorizontalPager component for swiping between pages
        HorizontalPager(
            count = dataList.size, // Number of pages based on dataList
            state = pageState, // State to manage the current page
            modifier = Modifier
                .fillMaxWidth() // Make the pager take up the full width
                .weight(1f) // Allow the pager to take up the remaining space in the column
        ) { page ->
            // For each page, we display a PageUI composable
            PageUI(pager = dataList[page])
        }

        // Pager indicator to show the current page with dots
        HorizontalPagerIndicator(
            pagerState = pageState, // Connect it to the pager's state
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(20.dp),
            activeColor = colorResource(id = R.color.purple_200) // Change the active dot color
        )

        // Show the "Getting Started" button only when the last page is reached
        AnimatedVisibility(visible = pageState.currentPage == 1) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
            }
        }
    }
}

@Composable
fun PageUI(pager: Pager) {
    Column(
        modifier = Modifier.fillMaxSize(), // Fill the available size for each page
        verticalArrangement = Arrangement.Center, // Center content vertically
        horizontalAlignment = Alignment.CenterHorizontally // Center content horizontally
    ) {
        // Image on each page
        Image(
            painter = painterResource(id = pager.image), // Load the image using the painter resource
            contentDescription = pager.title, // Provide a description for accessibility
            modifier = Modifier.size(200.dp) // Set the size of the image
        )
        Spacer(modifier = Modifier.height(20.dp)) // Add some space between the image and title
        Text(text = pager.title) // Display the title of the page
    }
}
