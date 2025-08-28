package com.example.gronic.ui.components

import com.example.gronic.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronic.domain.model.CategoryListItem
import com.example.gronic.ui.theme.GreenBodyBackground


@Composable
fun CategoryItemCard(
    modifier: Modifier = Modifier,
    count: Int = 0,
    item: CategoryListItem,
    onAdd: (CategoryListItem) -> Unit,
    onRemove: (CategoryListItem) -> Unit
) {
//    var count by remember { mutableStateOf(0) }

    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = modifier
            .padding(8.dp)
//            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.name,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = 8.dp)
                ) {
                    Text(item.name, style = MaterialTheme.typography.titleMedium)

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "$${item.price}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(bottom = 2.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "$${item.offerPrice}",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        color = Color(0xFF2E7D32)
                    )
                }

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 16.dp))
                        .background(GreenBodyBackground),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if(count > 0) {
                        IconButton(
                            onClick = { onRemove(item) },
                        ) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = "Remove")
                        }
                        Text(
                            text = "$count kg",
                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        )
                    }

                    // Add button
                    IconButton(onClick = { onAdd(item) }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewCategoryItemCard() {
    CategoryItemCard(
        item = CategoryListItem(1, "Fruits", 3.99, 1.0, imageRes = R.drawable.fruits),
        onAdd = {}, onRemove = {}
    )
}