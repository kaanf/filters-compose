package com.crewl.pentidemo.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.crewl.pentidemo.nav.Screen

@Composable
fun ColorScreen(navigator: NavHostController = rememberNavController()) {
    /* Empty screen. */
}

@Preview
@Composable
fun PreviewColorScreen() {
    ColorScreen()
}
