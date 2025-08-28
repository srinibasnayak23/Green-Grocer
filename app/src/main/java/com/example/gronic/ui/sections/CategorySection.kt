package com.example.gronic.ui.sections
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gronic.domain.model.Category
import com.example.gronic.ui.components.*

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    title: String = "Categories",
    categories: List<Category>,
    onSeeAllClick: () -> Unit,
    onCategoryClick: (Category) -> Unit,
) {

    Column(
        modifier = modifier
    ) {
        SectionHeader(
            title = title,
            onSeeAllClick = onSeeAllClick
        )

//        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            modifier = Modifier.padding(bottom = 8.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(categories) { category ->
                ProductCategory(
                    itemName = category.name,
                    imgRes = category.imageRes,
                    modifier = Modifier.clickable { onCategoryClick(category) }
                )
            }
        }
    }
}


data class Category(
    val name: String,
    val imageRes: Int
)

@Preview(showBackground = true)
@Composable
fun CategorySectionPreview() {
    val sampleCategories = listOf(
        Category("Electronics", android.R.drawable.ic_menu_camera),
        Category("Clothing", android.R.drawable.ic_menu_compass),
        Category("Home", android.R.drawable.ic_menu_gallery),
        Category("Books", android.R.drawable.ic_menu_info_details),
        Category("Toys", android.R.drawable.ic_menu_manage),
    )

    CategorySection(
        categories = sampleCategories,
        onSeeAllClick = { /* Preview action */ },
        onCategoryClick = { /* Preview action */ }
    )
}
