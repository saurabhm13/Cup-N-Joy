package com.example.cupnjoy.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cupnjoy.R
import com.example.cupnjoy.data.Coffee
import com.example.cupnjoy.data.coffeeList
import com.example.cupnjoy.ui.theme.Yellow

@Composable
fun CoffeeCard(
    coffeeInfo: Coffee
) {
    Surface(
        modifier = Modifier.padding(5.dp),
        shape = RoundedCornerShape(15.dp)
    ) {

        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Box(
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    painter = rememberAsyncImagePainter(model = coffeeInfo.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Surface (
                    shape = RoundedCornerShape(bottomEnd = 10.dp),
                    modifier = Modifier
                        .height(25.dp)
                        .width(60.dp)
                        .clip(RoundedCornerShape(bottomEnd = 10.dp))
                        .alpha(0.6f)
                        .blur(3.dp),
                ) {

                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = stringResource(
                            id = R.string.rating
                        ),
                        tint = Yellow
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = coffeeInfo.rating.toString(),
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = coffeeInfo.name,
                style = MaterialTheme.typography.labelLarge,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1F),
                    text = "$${coffeeInfo.price}",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )

                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "Favorite Icon",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(8.dp),
                )

            }
        }


    }
}

@Preview
@Composable
fun CoffeeCardPreview() {
    CoffeeCard(coffeeInfo = coffeeList[0])
}