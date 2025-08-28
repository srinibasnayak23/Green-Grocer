package com.example.gronic.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gronic.R
import com.example.gronic.domain.model.Category
import com.example.gronic.domain.model.Deal
import com.example.gronic.domain.model.PromoDiscount
import com.example.gronic.ui.sections.HomeScreenHeader
import com.example.gronic.ui.components.PromoDiscountCard
import com.example.gronic.ui.sections.CategorySection
import com.example.gronic.ui.sections.PopularDeal
import com.example.gronic.ui.theme.GreenBodyBackground
import com.example.gronic.ui.theme.OffWhiteBodyBackground
import com.example.gronic.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    categories: List<Category>,
    deals: List<Deal>,
    offers: List<PromoDiscount>,
    onSeeAllCategoriesClick: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(GreenBodyBackground)
//            .padding(16.dp)
    ) {
        var searchQuery by remember { mutableStateOf("") }

        HomeScreenHeader(
            searchText = searchQuery,
            onSearchTextChange = { searchQuery = it },
            onLogout,
            onChangeImageClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(top = 25.dp)
        )

        Spacer(Modifier.height(4.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    OffWhiteBodyBackground,
                    shape =RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
        ){
            // Categories Section

            CategorySection(
                modifier = Modifier
                    .padding(16.dp)
                    .heightIn(min = 220.dp)
                    .background(
                        White,
                        shape = MaterialTheme.shapes.large
                    ),
                categories = categories,
                onSeeAllClick = onSeeAllCategoriesClick,
                onCategoryClick = { category ->
                    navController.navigate("category/${category.name}")
                }

            )

            Spacer(Modifier.height(24.dp))

            LazyRow (
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()) {
                items(offers) { offer ->
                    PromoDiscountCard(
                        modifier = Modifier.width(280.dp),
                        discountText = offer.discountText,
                        subtitle = offer.subtitle,
                        ctaText = offer.ctaText,
                        onCtaClick = { /* Handle click */ },
                        containerColor = offer.containerColor,
                        contentColor = offer.contentColor,
                        illustrationRes = offer.illustrationRes
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            // Popular deals Section

            PopularDeal(
                modifier = Modifier
                    .padding(16.dp)
                    .heightIn(min = 280.dp)
                    .background(
                        White,
                        shape = MaterialTheme.shapes.large
                    ),
                deals = deals,
                onSeeAllClick = {},
                onDealClick = {  }
            )

            // Categories Section

            CategorySection(
                modifier = Modifier
                    .padding(16.dp)
                    .heightIn(min = 210.dp)
                    .background(
                        White,
                        shape = MaterialTheme.shapes.large
                    ),
                categories = categories,
                onSeeAllClick = { /* Navigate to all categories */ },
                onCategoryClick = {
                    // Handle category click
                }
            )



        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    val sampleCategories = listOf(
//        Category("Electronics", android.R.drawable.ic_menu_camera),
//        Category("Clothing", android.R.drawable.ic_menu_compass),
//        Category("Home", android.R.drawable.ic_menu_gallery),
//        Category("Books", android.R.drawable.ic_menu_info_details),
//        Category("Toys", android.R.drawable.ic_menu_manage),
//    )
//
//    val sampleDeals = listOf(
//        Deal(1, "Fresh Vegetables", R.drawable.fruits, "$12.50"),
//        Deal(2, "Red Meat", R.drawable.fruits, "$25.99"),
//        Deal(3, "Organic Fruits", R.drawable.fruits, "$8.90"),
//        Deal(1, "Fresh Vegetables", R.drawable.fruits, "$12.50"),
//        Deal(2, "Red Meat", R.drawable.fruits, "$25.99"),
//    )
//
//    val sampleOffers = listOf(
//        PromoDiscount(
//            discountText = "30% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            containerColor = Color(0xFFCDEFD9),
//            contentColor = Color(0xFF0F5132),
//            illustrationRes = R.drawable.fruits // replace with your drawable
//        ),
//        // 15% Discount Card
//        PromoDiscount(
//            discountText = "15% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            containerColor = Color(0xFFFFE2B5),
//            contentColor = Color(0xFF92400E),
//            illustrationRes = R.drawable.fruits // replace with your drawable
//        ),
//                // 12% Discount Card
//        PromoDiscount(
//            discountText = "12% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            containerColor = Color(0xFFD9F2E6),
//            contentColor = Color(0xFF0F5132),
//            illustrationRes = R.drawable.fruits // replace with your drawable
//        )
//    )
//
//    MaterialTheme {
//        HomeScreen(
//            navController = NavController(context = LocalContext.current),
//            categories = sampleCategories,
//            deals = sampleDeals,
//            offers = sampleOffers,
//        )
//    }
//}
