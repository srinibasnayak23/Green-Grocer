package com.example.gronic.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronic.domain.model.Review

@Composable
fun DetailsTabs(
    description: String,
    highlights: List<String>,
    reviews: List<Review>
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.White
    ) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = { selectedTabIndex = 0 }
        ) {
            Text("Details", modifier = Modifier.padding(12.dp))
        }
        Tab(
            selected = selectedTabIndex == 1,
            onClick = { selectedTabIndex = 1 }
        ) {
            Text("Reviews (${reviews.size})", modifier = Modifier.padding(12.dp))
        }
    }

    when (selectedTabIndex) {
        // 📌 Details Tab
        0 -> Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF2E7D32),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Product Details",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "Highlights:",
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.White)
                )

                Spacer(Modifier.height(8.dp))

                highlights.forEach {
                    Text("• $it", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White))
                }
            }
        }

        // 📌 Reviews Tab
        1 -> Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF2E7D32),
            modifier = Modifier
                .padding(16.dp)
                .height(180.dp)
                .fillMaxWidth()
       ) {
            if (reviews.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(reviews) { review ->
                        Column {
                            Text(
                                text = review.author,
                                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Yellow)
                            )
                            Text(
                                text = review.text,
                                style = MaterialTheme.typography.bodySmall.copy(color = Color.White)
                            )
                        }
                    }
                }
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No reviews yet.",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                    )
                }
            }
        }
    }
}


// --- Preview
@Preview(showBackground = true)
@Composable
fun DetailsTabsPreview() {
    val sampleReviews = listOf(
        Review("Alice", "Great product! Very useful and high quality."),
        Review("Bob", "It was okay, but shipping took too long."),
        Review("Charlie", "Excellent! I use it every day."),
        Review("Diana", "Not worth the price in my opinion."),
        Review("Ethan", "Amazing experience, will definitely recommend.")
    )

    MaterialTheme {
        DetailsTabs(
            description = "This is a detailed description of the product. It explains features, usage, and benefits.",
            highlights = listOf("Durable", "Lightweight", "Eco-friendly"),
            reviews = sampleReviews
        )
    }
}