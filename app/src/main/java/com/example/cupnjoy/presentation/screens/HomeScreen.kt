package com.example.cupnjoy.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupnjoy.R
import com.example.cupnjoy.data.coffeeList
import com.example.cupnjoy.presentation.components.CoffeeCard
import com.example.cupnjoy.presentation.components.CustomCurvedShape
import com.example.cupnjoy.ui.theme.DarkGrey

@Composable
fun HomeScreen() {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp)
            ) {

                // Search
                Spacer(modifier = Modifier.height(5.dp))
                Search()

                // Promo
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(id = R.string.promo_of_a_day),
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    painter = painterResource(id = R.drawable.poromo_banner),
                    contentDescription = stringResource(
                        id = R.string.promo
                    ),
                    contentScale = ContentScale.Crop
                )

                // Products
                Spacer(modifier = Modifier.height(15.dp))
                LazyVerticalGrid(
                    modifier = Modifier.padding(start = 50.dp),
                    columns = GridCells.Fixed(2),
                    content = {
                        items(coffeeList.size) { index ->
                            CoffeeCard(coffeeInfo = coffeeList[index])
                        }
                    }
                )
            }

            // Side Bar
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .height(450.dp)
                    .width(50.dp),
                shape = CustomCurvedShape()
            ) {
                SideBarItems()
            }
        }
    }
}

@Composable
private fun SideBarItems() {

    val categoryList = listOf(
        R.string.cappuccino,
        R.string.cortado,
        R.string.americano,
        R.string.espresso,
        R.string.flat_white
    )

    var selectedCategory by remember {
        mutableIntStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        for ((index, category) in categoryList.withIndex()) {
            Text(
                text = stringResource(id = category),
                style = if (selectedCategory == index) MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.Bold
                )
                else MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .rotate(-90f)
                    .clickable { selectedCategory = index }
                    .wrapContentWidth(
                        align = Alignment.CenterHorizontally,
                        unbounded = true
                    )
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
        }
    }
}

@Composable
private fun Search() {

    var searchQuery by remember {
        mutableStateOf("")
    }

    Row {
        TextField(
            value = searchQuery, onValueChange = { searchQuery = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.coffee_of_a_day),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = stringResource(
                        id = R.string.search
                    ),
                    tint = Color.White
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .weight(1F)
                .height(55.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = DarkGrey,
                unfocusedContainerColor = DarkGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),

            )

        Spacer(modifier = Modifier.width(15.dp))

        Surface(
            modifier = Modifier
                .height(55.dp)
                .width(55.dp),
            shape = RoundedCornerShape(15.dp),
            color = DarkGrey,
        ) {
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = R.drawable.cart),
                contentDescription = stringResource(id = R.string.cart),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}