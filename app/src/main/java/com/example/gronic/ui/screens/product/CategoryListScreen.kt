package com.example.gronic.ui.screens.product.SubCategoryScreen

import com.example.gronic.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.gronic.domain.model.CategoryListItem
import com.example.gronic.domain.model.ProductDetails
import com.example.gronic.ui.components.CategoryItemCard
import com.example.gronic.ui.theme.GreenBodyBackground
import com.example.gronic.ui.theme.OffWhiteBodyBackground

@Composable
fun CategorylistScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    category: String,
    itemList: List<CategoryListItem>
) {
    val counts = remember { mutableStateMapOf<Int, Int>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                GreenBodyBackground,
            )

    ) {
        Text(
            text = "${category}",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 34.dp, bottom = 34.dp)
        )

            // Example: display categories in a grid
            LazyVerticalGrid(
                columns = GridCells.Adaptive(150.dp),
                modifier = Modifier
                    .fillMaxSize()
//                    .padding(8.dp)
                    .background(
                        OffWhiteBodyBackground,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    ),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(itemList) { item ->
                    val count = counts[item.id] ?: 0
                    CategoryItemCard(
                        modifier.clickable { navController.navigate("category/${category}/${item.id}") },
                        count = count, // pass current count
                        item = item,
                        onAdd = { counts[item.id] = count + 1 }, // increment count in parent
                        onRemove = { counts[item.id] = (count - 1).coerceAtLeast(0) } // decrement safely
                    )
                }
            }

    }
}





//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun FruitListScreenPreview() {
//    MaterialTheme {
//        val subCategoryItems = listOf(
//            CategoryListItem(1, "Apple", "Fresh and juicy", 2.99, R.drawable.apple),
//            CategoryListItem(2, "Banana", "Sweet and ripe", 1.49, R.drawable.banana),
//            CategoryListItem(3, "Orange", "Rich in Vitamin C", 3.29, R.drawable.orange)
//        )
//
//        SubCategoryScreen(item = subCategoryItems)
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CategoryListScreenPreview() {
    MaterialTheme {
        val categoryItems = listOf(
            CategoryListItem(1, "Apple", 12.0, 2.99, R.drawable.fruits),
            CategoryListItem(2, "Banana", 20.0, 1.49, R.drawable.fruits),
            CategoryListItem(3, "Orange", 15.0, 3.29, R.drawable.fruits),
            CategoryListItem(4, "Grapes", 8.0, 4.99, R.drawable.fruits),
            CategoryListItem(5, "Mango", 5.0, 5.99,           R.drawable.fruits),
            CategoryListItem(6, "Pineapple", 7.0, 3.99, R.drawable.fruits),
            CategoryListItem(7, "Apple", 12.0, 2.99, R.drawable.fruits),
            CategoryListItem(2, "Banana", 20.0, 1.49, R.drawable.fruits),
            CategoryListItem(3, "Orange", 15.0, 3.29, R.drawable.fruits),
            CategoryListItem(4, "Grapes", 8.0, 4.99, R.drawable.fruits),
            CategoryListItem(5, "Mango", 5.0, 5.99,           R.drawable.fruits),
            CategoryListItem(6, "Pineapple", 7.0, 3.99, R.drawable.fruits)
        )
        CategorylistScreen(modifier = Modifier, itemList = categoryItems, category = "Fruits", navController = NavController(LocalContext.current))
    }
}