package com.crewl.pentidemo.ui

import android.widget.CheckBox
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.crewl.pentidemo.R
import com.crewl.pentidemo.nav.SetupNavigationGraph

@Composable
fun ProductListDrawerMenu(navHostController: NavHostController, closeDrawer: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 110.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(1f, false)
        ) {
            ProductListDrawerHeader(closeDrawer, isDrawerMenuNavigated = false)

            Divider(
                color = Color(0xfffaf0f4),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
            )

            SetupNavigationGraph(navController = navHostController)
        }

        Divider(
            color = Color(0xfffaf0f4),
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
        )

        ProductListDrawerFooter()
    }
}

@Composable
fun ProductListDrawerFooter(onButtonClicked: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(Color.White))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = { },
            shape = RoundedCornerShape(15),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color(0xfffa5373))
        ) {
            Text(text = "644 Ürünü Göster", style = TextStyle(color = Color.White, fontSize = 15.sp))
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White))
    }
}

data class DrawerContent(
    val title: String,
    val imageVector: ImageVector,
    val isCheckable: Boolean
)