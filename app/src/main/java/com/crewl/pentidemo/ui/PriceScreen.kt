package com.crewl.pentidemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.crewl.pentidemo.components.RangeSlider

@Composable
fun PriceScreen(navigator: NavHostController = rememberNavController()) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        RangeSlider(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .fillMaxWidth(),
            rangeColor = Color(0xfffa5373),
            backColor = Color(203, 225, 246),
            barHeight = 6.dp,
            circleRadius = 16.dp,
            progress1InitialValue = 0.0f,
            progress2InitialValue = 1.0f,
            tooltipSpacing = 10.dp,
            tooltipWidth = 40.dp,
            tooltipHeight = 30.dp,
            cornerRadius = CornerRadius(32f, 32f),
            tooltipTriangleSize = 8.dp,
        ) { _, _ ->

        }
    }
}

@Composable
@Preview
fun PreviewPriceScreen() {
    PriceScreen()
}