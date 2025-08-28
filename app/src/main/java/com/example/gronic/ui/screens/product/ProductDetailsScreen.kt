package com.example.gronic.ui.screens.product


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
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

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.gronic.R
import com.example.gronic.domain.model.Review
import com.example.gronic.ui.components.DetailsTabs


@Composable
fun ProductDetailsScreen(
    modifier: Modifier = Modifier,
    productName: String = "Orange - Yellow",
    productSubtitle: String = "$17.00/kg",
    productImageRes: Int,
    price: String = "$17.20",
    calories: String = "14 Calories",
    rating: String = "4.5",
    reviewCount: Int = 256,
    discountPercent: String = "-55%",
    description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
    highlights: List<String> = listOf(
        "Provides more vitamin C than an orange",
        "High levels of antioxidants"
    ),
    reviews: List<Review>,
    quantity: Int = 1,
    onQuantityChange: (Int) -> Unit = {},
    onAddToCart: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Product Image with discount badge
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = productImageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            // Discount badge
            Text(
                text = discountPercent,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
                    .background(Color.Red, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }

        // Product card info
        Surface(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            tonalElevation = 1.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = productName,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = productSubtitle,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(text = price, style = MaterialTheme.typography.titleMedium)
                    Text(text = calories, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "⭐ $rating ($reviewCount)", style = MaterialTheme.typography.bodyMedium)
                }

                Spacer(Modifier.height(12.dp))

                // Quantity selector
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Decrease")
                    }
                    Text(
                        text = "$quantity kg",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    IconButton(onClick = { onQuantityChange(quantity + 1) }) {
                        Icon(Icons.Default.Add, contentDescription = "Increase")
                    }
                }
            }
        }

//        Spacer(Modifier.height(16.dp))
//
//        // Tabs (Details / Reviews)
//        var selectedTabIndex by remember { mutableStateOf(0) }
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            containerColor = Color.White
//        ) {
//            Tab(
//                selected = selectedTabIndex == 0,
//                onClick = { selectedTabIndex = 0 }
//            ) {
//                Text("Details", modifier = Modifier.padding(12.dp))
//            }
//            Tab(
//                selected = selectedTabIndex == 1,
//                onClick = { selectedTabIndex = 1 }
//            ) {
//                Text("Reviews ($reviewCount)", modifier = Modifier.padding(12.dp))
//            }
//        }

        Spacer(Modifier.height(8.dp))

        // Show content depending on selected tab
        DetailsTabs(highlights = highlights, reviews = reviews, description = description)
//        when (selectedTabIndex) {
//            // Details content
//            0 -> Surface(
//                shape = RoundedCornerShape(12.dp),
//                color = Color(0xFF2E7D32),
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .fillMaxWidth()
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = description,
//                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
//                    )
//
//                    Spacer(Modifier.height(12.dp))
//
//                    highlights.forEach {
//                        Text("• $it", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
//                    }
//                }
//            }
//            // Review content
//            1 -> Surface(
//                shape = RoundedCornerShape(12.dp),
//                color = Color(0xFF2E7D32),
//                modifier = Modifier
//                    .padding(horizontal = 16.dp)
//                    .fillMaxWidth()
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = "Reviews ($reviewCount)",
//                        style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
//                    )
//
//                    Spacer(Modifier.height(12.dp))
//
//                    if (reviews.isNotEmpty()) {
//                        reviews.forEach { review ->
//                            Column(modifier = Modifier.padding(bottom = 12.dp)) {
//                                Text(
//                                    text = review.author,
//                                    style = MaterialTheme.typography.bodyMedium.copy(
//                                        color = Color.Yellow
//                                    )
//                                )
//                                Text(
//                                    text = review.text,
//                                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
//                                )
//                            }
//                        }
//                    } else {
//                        Text(
//                            text = "No reviews yet.",
//                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
//                        )
//                    }
//                }
//            }
//        }

        Spacer(Modifier.height(24.dp))

        // Bottom price & Add to cart button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$14.25",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )

            Button(
                onClick = onAddToCart,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                Spacer(Modifier.width(8.dp))
                Text("Add to cart")
            }
        }
    }
}


//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun ProductDetailsScreenPreview() {
//    MaterialTheme {
//        ProductDetailsScreen(
//            productName = "Orange - Yellow",
//            productSubtitle = "$17.00/kg",
//            productImageRes = R.drawable.fruits, // replace with your drawable
//            price = "$17.20",
//            calories = "14 Calories",
//            rating = "4.5",
//            reviewCount = 256,
//            discountPercent = "-55%",
//            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
//            highlights = listOf(
//                "Provides more vitamin C than an orange",
//                "High levels of antioxidants"
//            ),
//            quantity = 4,
//            onQuantityChange = {},
//            onAddToCart = {}
//        )
//    }
//}
