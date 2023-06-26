package com.crewl.pentidemo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.crewl.pentidemo.R
import com.crewl.pentidemo.nav.Screen

@Composable
fun FiltersScreen(navigator: NavHostController, closeDrawer: () -> Unit = {}) {

    val items = getItemContent()

    ProductListDrawerBody(items = items, onItemClicked = {
        if (it.title == "Fiyat")
            navigator.navigate(Screen.PriceScreen.route)
        else
            navigator.navigate(Screen.ColorScreen.route)
    })
}

private fun getItemContent(): List<DrawerContent> {
    return listOf(
        DrawerContent(title = "Beden", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Fiyat", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Renk", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Kumaş", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Balen", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Dolgu", imageVector = Icons.Default.Home, false),
        DrawerContent(title = "Denye", imageVector = Icons.Default.ShoppingCart, false),
        DrawerContent(title = "Cinsiyet", imageVector = Icons.Default.ShoppingCart, false),
        DrawerContent(title = "Stokta", imageVector = Icons.Default.ShoppingCart, true),
        DrawerContent(title = "İndirimde", imageVector = Icons.Default.ShoppingCart, true),
        DrawerContent(title = "Sürdürülebilir", imageVector = Icons.Default.ShoppingCart, true),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListDrawerHeader(onActionClick: () -> Unit = {}, isDrawerMenuNavigated: Boolean) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .background(Color.White),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
        title = { Text(text = "Filtreler", style = TextStyle(color = Color(0xff81819b), fontSize = 18.sp)) },
        navigationIcon = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Icon for close drawer menu.",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            if (isDrawerMenuNavigated)
                IconButton(onClick = onActionClick) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Remove selected filters.",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
        },
    )
}

@Composable
fun ProductListDrawerBody(items: List<DrawerContent>, onItemClicked: (DrawerContent) -> Unit) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            ProductListDefaultDrawerItem(item = item, onItemClicked)

            if (index < items.lastIndex)
                Divider(color = Color.White, thickness = 1.dp)
        }
    }
}

@Composable
fun ProductListDefaultDrawerItem(
    item: DrawerContent,
    onItemClicked: (DrawerContent) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(if (isChecked) Color(0xfffaf0f4) else Color.White)
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable {
                onItemClicked.invoke(item)
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.title, style = TextStyle(color = Color(0xff29335c), fontSize = 15.sp), modifier = Modifier.padding(8.dp))

        if (item.isCheckable)
            Card(
                modifier = Modifier
                    .padding(horizontal = 4.dp),
                shape = RoundedCornerShape(4.dp),
                border = BorderStroke(1.25.dp, color = Color(0xfffa5373))
            ) {
                Box(
                    modifier = Modifier
                        .background(if (isChecked) Color(0xfffaf0f4) else Color.White)
                        .size(20.dp)
                        .clickable {
                            isChecked = !isChecked
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (isChecked)
                        Icon(Icons.Default.Check, contentDescription = "", tint = Color(0xfffa5373), modifier = Modifier.padding(4.dp))
                }
            }
        else
            Image(
                painterResource(R.drawable.icons_keyboard_arrow),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 4.dp)
            )
    }
}