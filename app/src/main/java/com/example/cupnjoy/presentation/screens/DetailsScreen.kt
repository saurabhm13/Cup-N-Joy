package com.example.cupnjoy.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cupnjoy.R
import com.example.cupnjoy.data.Coffee
import com.example.cupnjoy.data.coffeeList
import com.example.cupnjoy.ui.theme.Yellow
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    coffeeInfo: Coffee
) {

    val scrollState = rememberScrollState()
    var favorite by remember {
        mutableStateOf(false)
    }

    Scaffold(topBar = {
        CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ), title = {
            Text(stringResource(id = R.string.product_details))
        }, navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_left),
                    contentDescription = stringResource(
                        id = R.string.back
                    )
                )
            }
        },

            actions = {
                IconButton(onClick = { favorite = !favorite }) {
                    Image(
                        painter = painterResource(id = if (favorite) R.drawable.heart else  R.drawable.ic_like_outlined),
                        contentDescription = stringResource(
                            id = R.string.back
                        )
                    )
                }
            }

        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 15.dp)
                .verticalScroll(scrollState)
        ) {

            // Image Section and Highlights
            ImageSectionAndHighlights(coffeeInfo)

            // Description
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = stringResource(id = R.string.description),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = coffeeInfo.description, style = MaterialTheme.typography.labelLarge
            )

            // Coffee Size
            CoffeeSize()

            // Milk Type
            MilkType()

            // Buy Now
            Spacer(modifier = Modifier.height(30.dp))
            ElevatedButton(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),
                onClick = { }) {
                Text(text = stringResource(id = R.string.buy_now))
            }

            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
private fun ImageSectionAndHighlights(
    coffeeInfo: Coffee
) {

    val hazeState = remember { HazeState() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .haze(hazeState)
                .height(400.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = rememberAsyncImagePainter(model = coffeeInfo.image),
                contentDescription = null,
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.FillHeight
            )

            val boxModifier = Modifier
                .hazeChild(
                    state = hazeState,
                    shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp),
                    style = HazeMaterials.ultraThin()
                )
                .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                .background(Color.Transparent)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(130.dp)


            Box(modifier = boxModifier) {}
        }


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(130.dp)
                .padding(15.dp)
        ) {
            CoffeeHighlights(coffeeInfo)
        }
    }
}

@Composable
private fun CoffeeHighlights(coffeeInfo: Coffee) {
    Row {
        Column(
            modifier = Modifier
                .weight(1F)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = coffeeInfo.name, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "$${coffeeInfo.price}",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.width(6.dp))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = stringResource(
                        id = R.string.rating
                    ),
                    tint = Yellow
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = coffeeInfo.rating.toString(),
                    style = MaterialTheme.typography.labelMedium
                )

                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "(${coffeeInfo.ratingCount})",
                    style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
            ElevatedButton(shape = RoundedCornerShape(10.dp), onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.add_to_cart))
            }
        }

    }
}

@Composable
private fun MilkType() {

    val milkType = listOf(
        R.string.oat,
        R.string.soy,
        R.string.almond,
    )

    var selectedMilk by remember {
        mutableIntStateOf(0)
    }

    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = stringResource(id = R.string.milk),
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
    )

    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for ((index, size) in milkType.withIndex()) {
            Surface(
                modifier = Modifier
                    .border(
                        width = if (selectedMilk == index) 1.dp else 0.dp,
                        color = if (selectedMilk == index) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { selectedMilk = index },
                shape = RoundedCornerShape(6.dp),
                color = if (selectedMilk == index) Color.Transparent
                else MaterialTheme.colorScheme.surface
            ) {
                Text(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(vertical = 5.dp),
                    text = stringResource(id = size),
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = if (selectedMilk == index) MaterialTheme.colorScheme.secondary
                        else Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun CoffeeSize() {

    val coffeeSize = listOf(
        R.string.small,
        R.string.medium,
        R.string.large,
    )

    var selectedSize by remember {
        mutableIntStateOf(0)
    }

    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = stringResource(id = R.string.size),
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
    )

    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for ((index, size) in coffeeSize.withIndex()) {
            Surface(
                modifier = Modifier
                    .border(
                        width = if (selectedSize == index) 1.dp else 0.dp,
                        color = if (selectedSize == index) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.surface,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .clickable { selectedSize = index },
                shape = RoundedCornerShape(6.dp),
                color = if (selectedSize == index) Color.Transparent
                else MaterialTheme.colorScheme.surface
            ) {
                Text(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(vertical = 5.dp),
                    text = stringResource(id = size),
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = if (selectedSize == index) MaterialTheme.colorScheme.secondary
                        else Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(coffeeInfo = coffeeList[2])
}