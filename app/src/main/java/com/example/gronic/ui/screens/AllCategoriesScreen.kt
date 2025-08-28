package com.example.gronic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gronic.domain.model.Category
import com.example.gronic.ui.components.ProductCategory
import com.example.gronic.ui.theme.GreenBodyBackground
import com.example.gronic.ui.theme.OffWhiteBodyBackground

@Composable
fun AllCategoriesScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                GreenBodyBackground,
            )

    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 34.dp, bottom = 34.dp)
        )

        Surface(
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
                .background(
                    OffWhiteBodyBackground,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )

                .padding(top = 1.dp, start = 24.dp, end = 24.dp),
        ) {
            // Example: display categories in a grid
            LazyVerticalGrid(
                modifier = Modifier
                    .background(
                        OffWhiteBodyBackground,
                    )
                    .fillMaxSize(),
                columns = GridCells.Adaptive(minSize = 100.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { category ->
                    ProductCategory(modifier = Modifier.clickable { onCategoryClick(category) }, itemName = category.name, imgRes = category.imageRes )
                }
            }
        }
    }
}
