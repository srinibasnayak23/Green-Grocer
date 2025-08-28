package com.example.gronic.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gronic.R
import com.example.gronic.domain.model.Category
import com.example.gronic.domain.model.CategoryListItem
import com.example.gronic.domain.model.Deal
import com.example.gronic.domain.model.Offer
import com.example.gronic.domain.model.ProductDetails
import com.example.gronic.domain.model.PromoDiscount
import com.example.gronic.domain.model.Review
import com.example.gronic.ui.components.NavigationBar
import com.example.gronic.ui.navigation.NavItem
import com.example.gronic.ui.screens.product.ProductDetailsScreen
import com.example.gronic.ui.screens.product.SubCategoryScreen.CategorylistScreen

@Composable
fun MainScreen(onLogout: () -> Unit = {}) {
    val navController = rememberNavController()

    Button(onClick = onLogout) {
        Text("Logout")
    }

    Scaffold(
        bottomBar = { NavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
//            composable(NavItem.Home.route) { HomeScreen() }
            composable(NavItem.Home.route) {
                val sampleCategories = listOf(
                    Category("Fruits", R.drawable.fruits),
                    Category("Electronics", android.R.drawable.ic_menu_camera),
                    Category("Clothing", android.R.drawable.ic_menu_compass),
                    Category("Home", android.R.drawable.ic_menu_gallery),
                    Category("Books", android.R.drawable.ic_menu_info_details),
                    Category("Toys", android.R.drawable.ic_menu_manage),
                    Category("Sports", android.R.drawable.ic_menu_directions),
                    Category("Beauty", android.R.drawable.ic_menu_week),
                    Category("Health", android.R.drawable.ic_menu_help),
                    Category("Groceries", android.R.drawable.ic_menu_crop),
                    Category("Furniture", android.R.drawable.ic_menu_view),
                    Category("Jewelry", android.R.drawable.ic_menu_myplaces),
                    Category("Shoes", android.R.drawable.ic_menu_sort_by_size),
                    Category("Music", android.R.drawable.ic_media_play),
                    Category("Movies", android.R.drawable.ic_media_ff),
                    Category("Garden", android.R.drawable.ic_menu_day)
                )


                val sampleDeals = listOf(
                    Deal(1, "Fresh Vegetables", R.drawable.grocery_item, "$12.50"),
                    Deal(2, "Red Meat", R.drawable.red_meat, "$25.99"),
                    Deal(3, "Organic Apples", R.drawable.fruits, "$8.99"),
                    Deal(4, "Grains", R.drawable.grains_png, "$18.75"),
                    Deal(5, "Fresh Salmon", R.drawable.fruits, "$22.40"),
                    Deal(6, "Cheddar Cheese", R.drawable.fruits, "$6.30"),
                    Deal(7, "Olive Oil", R.drawable.fruits, "$10.50"),
                    Deal(8, "Brown Bread", R.drawable.fruits, "$3.20"),
                    Deal(9, "Orange Juice", R.drawable.fruits, "$4.99"),
                    Deal(10, "Ice Cream Tub", R.drawable.fruits, "$7.60")
                )

                val sampleOffers = listOf(
                    PromoDiscount(
                        discountText = "20% OFF",
                        subtitle = "Discount on all fresh meat & seafood",
                        ctaText = "Order Today",
                        containerColor = Color(0xFFFFF59D),
                        contentColor = Color(0xFFF57F17),
                        illustrationRes = R.drawable.red_meat
                    ),
                    PromoDiscount(
                        discountText = "Free Delivery",
                        subtitle = "On orders above $50 Discount on all grains & rice",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFBBDEFB),
                        contentColor = Color(0xFF0D47A1),
                        illustrationRes = R.drawable.grocery_item
                    ),
                    PromoDiscount(
                        discountText = "Buy 1 Get 1 Free",
                        subtitle = "Valid on bakery items only",
                        ctaText = "Grab Offer",
                        containerColor = Color(0xFFD1C4E9),
                        contentColor = Color(0xFF311B92),
                        illustrationRes = R.drawable.grains_png
                    ),
                    PromoDiscount(
                        discountText = "30% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFCDEFD9),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.img_1 // replace with your drawable
                    ),
                    PromoDiscount(
                        discountText = "15% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFFFE2B5),
                        contentColor = Color(0xFF92400E),
                        illustrationRes = R.drawable.fruits
                    ),
                    PromoDiscount(
                        discountText = "12% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFD9F2E6),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.img_2
                    ),
                    PromoDiscount(
                        discountText = "50% OFF",
                        subtitle = "Special weekend deal on selected groceries",
                        ctaText = "Shop Now",
                        containerColor = Color(0xFFFFCDD2),
                        contentColor = Color(0xFFB71C1C),
                        illustrationRes = R.drawable.img_3
                    ),

                )


                HomeScreen(
                    navController = navController,
                    categories = sampleCategories,
                    deals = sampleDeals,
                    offers = sampleOffers,
                    onSeeAllCategoriesClick = {
                        navController.navigate("all_categories")
                    },
                    onLogout = onLogout
                )
            }

            composable(NavItem.Orders.route) { OrdersScreen() }
            composable(NavItem.Offers.route) {
                val offers = listOf(
                    Offer(
                        discountText = "30% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFCDEFD9),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.img_2
                    ),
                    Offer(
                        discountText = "15% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFFFE2B5),
                        contentColor = Color(0xFF92400E),
                        illustrationRes = R.drawable.img_3
                    ),
                    Offer(
                        discountText = "12% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFD9F2E6),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.img_1
                    ),
                    Offer(
                        discountText = "50% OFF",
                        subtitle = "Special weekend deal on fresh groceries",
                        ctaText = "Shop Now",
                        containerColor = Color(0xFFFFCDD2),
                        contentColor = Color(0xFFB71C1C),
                        illustrationRes = R.drawable.grocery_item
                    ),
                    Offer(
                        discountText = "Buy 1 Get 1 Free",
                        subtitle = "Applicable on bakery items only",
                        ctaText = "Grab Offer",
                        containerColor = Color(0xFFD1C4E9),
                        contentColor = Color(0xFF311B92),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "20% OFF",
                        subtitle = "Discount on all meat & seafood",
                        ctaText = "Order Today",
                        containerColor = Color(0xFFFFF59D),
                        contentColor = Color(0xFFF57F17),
                        illustrationRes = R.drawable.red_meat
                    ),
                    Offer(
                        discountText = "Free Delivery",
                        subtitle = "On orders above $50",
                        ctaText = "Start Shopping",
                        containerColor = Color(0xFFBBDEFB),
                        contentColor = Color(0xFF0D47A1),
                        illustrationRes = R.drawable.grains_png
                    ),
                    Offer(
                        discountText = "30% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFCDEFD9),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "15% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFFFE2B5),
                        contentColor = Color(0xFF92400E),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "12% Discount",
                        subtitle = "Order any food from app and get the discount",
                        ctaText = "Order Now",
                        containerColor = Color(0xFFD9F2E6),
                        contentColor = Color(0xFF0F5132),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "50% OFF",
                        subtitle = "Special weekend deal on fresh groceries",
                        ctaText = "Shop Now",
                        containerColor = Color(0xFFFFCDD2),
                        contentColor = Color(0xFFB71C1C),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "Buy 1 Get 1 Free",
                        subtitle = "Applicable on bakery items only",
                        ctaText = "Grab Offer",
                        containerColor = Color(0xFFD1C4E9),
                        contentColor = Color(0xFF311B92),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "20% OFF",
                        subtitle = "Discount on all meat & seafood",
                        ctaText = "Order Today",
                        containerColor = Color(0xFFFFF59D),
                        contentColor = Color(0xFFF57F17),
                        illustrationRes = R.drawable.fruits
                    ),
                    Offer(
                        discountText = "Free Delivery",
                        subtitle = "On orders above $50",
                        ctaText = "Start Shopping",
                        containerColor = Color(0xFFBBDEFB),
                        contentColor = Color(0xFF0D47A1),
                        illustrationRes = R.drawable.fruits
                    )
                )


                OfferScreen (offers = offers)
            }
            composable(NavItem.Cart.route) { CartScreen() }
            composable("all_categories") {
                val sampleCategories = listOf(
                    Category("Fruits", R.drawable.fruits_png),
                    Category("Electronics", android.R.drawable.ic_menu_camera),
                    Category("Clothing", android.R.drawable.ic_menu_compass),
                    Category("Home", android.R.drawable.ic_menu_gallery),
                    Category("Books", android.R.drawable.ic_menu_info_details),
                    Category("Toys", android.R.drawable.ic_menu_manage),
                    Category("Sports", android.R.drawable.ic_menu_directions),
                    Category("Beauty", android.R.drawable.ic_menu_week),
                    Category("Health", android.R.drawable.ic_menu_help),
                    Category("Groceries", R.drawable.grocery_item),
                    Category("Furniture", android.R.drawable.ic_menu_view),
                    Category("Jewelry", android.R.drawable.ic_menu_myplaces),
                    Category("Shoes", android.R.drawable.ic_menu_sort_by_size),
                    Category("Music", android.R.drawable.ic_media_play),
                    Category("Movies", android.R.drawable.ic_media_ff),
                    Category("Garden", android.R.drawable.ic_menu_day)
                )
                AllCategoriesScreen(navController = navController, categories = sampleCategories, onCategoryClick = { category ->
                    navController.navigate("category/${category.name}")
                })
            }
            composable(
                route = "category/{categoryName}",
                arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
                ) {backStackEntry ->

                // get argument from navigation
                val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""

                val categoryItems = when (categoryName) {
                    "Fruits" -> listOf(
                        CategoryListItem(1, "Apple", 12.0, 2.99, R.drawable.fruits),
                        CategoryListItem(2, "Banana", 20.0, 1.49, R.drawable.banana),
                        CategoryListItem(3, "Watermelon", 15.0, 3.29, R.drawable.fruits_png),
                        CategoryListItem(4, "Guava", 8.0, 4.99, R.drawable.guava_png),
                        CategoryListItem(5, "Strawberry", 5.0, 5.99, R.drawable.straberry),
                        CategoryListItem(6, "Pineapple", 7.0, 3.99, R.drawable.pineapple)
                    )

                    "Electronics" -> listOf(
                        CategoryListItem(1, "Camera", 5.0, 299.99, android.R.drawable.ic_menu_camera),
                        CategoryListItem(2, "Laptop", 10.0, 899.99, android.R.drawable.ic_menu_manage),
                        CategoryListItem(3, "Headphones", 15.0, 149.99, android.R.drawable.ic_media_play),
                        CategoryListItem(4, "Smartwatch", 8.0, 199.99, android.R.drawable.ic_menu_recent_history)
                    )

                    "Clothing" -> listOf(
                        CategoryListItem(1, "T-Shirt", 50.0, 19.99, android.R.drawable.ic_menu_compass),
                        CategoryListItem(2, "Jeans", 30.0, 49.99, android.R.drawable.ic_menu_compass),
                        CategoryListItem(3, "Jacket", 20.0, 89.99, android.R.drawable.ic_menu_compass),
                        CategoryListItem(4, "Sneakers", 25.0, 59.99, android.R.drawable.ic_menu_compass)
                    )

                    "Home" -> listOf(
                        CategoryListItem(1, "Cushion", 20.0, 14.99, android.R.drawable.ic_menu_gallery),
                        CategoryListItem(2, "Lamp", 15.0, 39.99, android.R.drawable.ic_menu_gallery),
                        CategoryListItem(3, "Curtains", 10.0, 49.99, android.R.drawable.ic_menu_gallery),
                        CategoryListItem(4, "Rug", 12.0, 79.99, android.R.drawable.ic_menu_gallery)
                    )

                    "Books" -> listOf(
                        CategoryListItem(1, "Novel", 30.0, 12.99, android.R.drawable.ic_menu_info_details),
                        CategoryListItem(2, "Science Book", 20.0, 29.99, android.R.drawable.ic_menu_info_details),
                        CategoryListItem(3, "History Book", 15.0, 24.99, android.R.drawable.ic_menu_info_details),
                        CategoryListItem(4, "Comics", 40.0, 9.99, android.R.drawable.ic_menu_info_details)
                    )

                    "Toys" -> listOf(
                        CategoryListItem(1, "Lego Set", 10.0, 59.99, android.R.drawable.ic_menu_manage),
                        CategoryListItem(2, "Action Figure", 20.0, 19.99, android.R.drawable.ic_menu_manage),
                        CategoryListItem(3, "Puzzle", 15.0, 14.99, android.R.drawable.ic_menu_manage),
                        CategoryListItem(4, "Doll", 25.0, 24.99, android.R.drawable.ic_menu_manage)
                    )

                    "Sports" -> listOf(
                        CategoryListItem(1, "Football", 30.0, 29.99, android.R.drawable.ic_menu_directions),
                        CategoryListItem(2, "Basketball", 25.0, 24.99, android.R.drawable.ic_menu_directions),
                        CategoryListItem(3, "Tennis Racket", 10.0, 79.99, android.R.drawable.ic_menu_directions),
                        CategoryListItem(4, "Cricket Bat", 12.0, 49.99, android.R.drawable.ic_menu_directions)
                    )

                    "Beauty" -> listOf(
                        CategoryListItem(1, "Lipstick", 50.0, 9.99, android.R.drawable.ic_menu_week),
                        CategoryListItem(2, "Foundation", 20.0, 19.99, android.R.drawable.ic_menu_week),
                        CategoryListItem(3, "Perfume", 15.0, 39.99, android.R.drawable.ic_menu_week),
                        CategoryListItem(4, "Nail Polish", 40.0, 4.99, android.R.drawable.ic_menu_week)
                    )

                    "Health" -> listOf(
                        CategoryListItem(1, "Vitamins", 30.0, 14.99, android.R.drawable.ic_menu_help),
                        CategoryListItem(2, "First Aid Kit", 10.0, 24.99, android.R.drawable.ic_menu_help),
                        CategoryListItem(3, "Protein Powder", 12.0, 49.99, android.R.drawable.ic_menu_help),
                        CategoryListItem(4, "Thermometer", 20.0, 7.99, android.R.drawable.ic_menu_help)
                    )

                    "Groceries" -> listOf(
                        CategoryListItem(1, "Rice (1kg)", 50.0, 3.99, android.R.drawable.ic_menu_crop),
                        CategoryListItem(2, "Flour (1kg)", 40.0, 2.99, android.R.drawable.ic_menu_crop),
                        CategoryListItem(3, "Cooking Oil (1L)", 30.0, 6.99, android.R.drawable.ic_menu_crop),
                        CategoryListItem(4, "Sugar (1kg)", 60.0, 2.49, android.R.drawable.ic_menu_crop)
                    )

                    "Furniture" -> listOf(
                        CategoryListItem(1, "Chair", 15.0, 49.99, android.R.drawable.ic_menu_view),
                        CategoryListItem(2, "Table", 10.0, 99.99, android.R.drawable.ic_menu_view),
                        CategoryListItem(3, "Sofa", 5.0, 299.99, android.R.drawable.ic_menu_view),
                        CategoryListItem(4, "Bed", 7.0, 399.99, android.R.drawable.ic_menu_view)
                    )

                    "Jewelry" -> listOf(
                        CategoryListItem(1, "Necklace", 5.0, 199.99, android.R.drawable.ic_menu_myplaces),
                        CategoryListItem(2, "Ring", 10.0, 149.99, android.R.drawable.ic_menu_myplaces),
                        CategoryListItem(3, "Bracelet", 8.0, 99.99, android.R.drawable.ic_menu_myplaces),
                        CategoryListItem(4, "Earrings", 12.0, 79.99, android.R.drawable.ic_menu_myplaces)
                    )

                    "Shoes" -> listOf(
                        CategoryListItem(1, "Running Shoes", 20.0, 59.99, android.R.drawable.ic_menu_sort_by_size),
                        CategoryListItem(2, "Casual Shoes", 15.0, 49.99, android.R.drawable.ic_menu_sort_by_size),
                        CategoryListItem(3, "Formal Shoes", 10.0, 89.99, android.R.drawable.ic_menu_sort_by_size),
                        CategoryListItem(4, "Sandals", 25.0, 29.99, android.R.drawable.ic_menu_sort_by_size)
                    )

                    "Music" -> listOf(
                        CategoryListItem(1, "Guitar", 5.0, 199.99, android.R.drawable.ic_media_play),
                        CategoryListItem(2, "Keyboard", 3.0, 299.99, android.R.drawable.ic_media_play),
                        CategoryListItem(3, "Drums", 2.0, 499.99, android.R.drawable.ic_media_play),
                        CategoryListItem(4, "Microphone", 10.0, 99.99, android.R.drawable.ic_media_play)
                    )

                    "Movies" -> listOf(
                        CategoryListItem(1, "DVD - Action Movie", 20.0, 14.99, android.R.drawable.ic_media_ff),
                        CategoryListItem(2, "DVD - Comedy Movie", 25.0, 12.99, android.R.drawable.ic_media_ff),
                        CategoryListItem(3, "Blu-ray - Drama", 15.0, 19.99, android.R.drawable.ic_media_ff),
                        CategoryListItem(4, "Blu-ray - Sci-Fi", 10.0, 24.99, android.R.drawable.ic_media_ff)
                    )

                    "Garden" -> listOf(
                        CategoryListItem(1, "Plant Pot", 30.0, 9.99, android.R.drawable.ic_menu_day),
                        CategoryListItem(2, "Garden Hose", 15.0, 19.99, android.R.drawable.ic_menu_day),
                        CategoryListItem(3, "Lawn Mower", 5.0, 199.99, android.R.drawable.ic_menu_day),
                        CategoryListItem(4, "Seeds Pack", 50.0, 2.99, android.R.drawable.ic_menu_day)
                    )

                    else -> emptyList()
                }

                CategorylistScreen(modifier = Modifier, itemList = categoryItems, category = categoryName, navController = navController)
            }

            composable(
                route = "category/{categoryName}/{itemId}",
                arguments = listOf(
                            navArgument("categoryName") { type = NavType.StringType },
                            navArgument("itemId") { type = NavType.IntType }
                )
            ) {backStackEntry ->

                // get argument from navigation
                val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
                val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1

                val sampleProductDetails = mapOf(
                    "Fruits" to listOf(
                        ProductDetails(
                            id = 1,
                            productName = "Apple",
                            productSubtitle = "$12.00/kg",
                            productImageRes = R.drawable.fruits,
                            price = "$12.00",
                            calories = "52 Calories",
                            rating = "4.7",
                            reviewCount = 340,
                            discountPercent = "-10%",
                            description = "Fresh red apples, rich in fiber and essential nutrients.",
                            highlights = listOf("High in fiber", "Supports heart health")
                        ),
                        ProductDetails(
                            id = 2,
                            productName = "Banana",
                            productSubtitle = "$5.00/dozen",
                            productImageRes = R.drawable.banana,
                            price = "$5.00",
                            calories = "89 Calories",
                            rating = "4.6",
                            reviewCount = 210,
                            discountPercent = "-15%",
                            description = "Sweet bananas, a great source of potassium and quick energy.",
                            highlights = listOf("Rich in potassium", "Boosts energy levels")
                        ),
                        ProductDetails(
                            id = 3,
                            productName = "Watermelon",
                            productSubtitle = "$17.00/kg",
                            productImageRes = R.drawable.fruits_png,
                            price = "$17.20",
                            calories = "47 Calories",
                            rating = "4.5",
                            reviewCount = 256,
                            discountPercent = "-55%",
                            description = "Juicy yellow oranges, packed with Vitamin C and antioxidants.",
                            highlights = listOf("Provides more vitamin C than an orange", "High levels of antioxidants")
                        ),
                        ProductDetails(
                            id = 4,
                            productName = "Guava",
                            productSubtitle = "$12.00/kg",
                            productImageRes = R.drawable.guava_png,
                            price = "$12.00",
                            calories = "52 Calories",
                            rating = "4.7",
                            reviewCount = 340,
                            discountPercent = "-10%",
                            description = "Fresh red apples, rich in fiber and essential nutrients.",
                            highlights = listOf("High in fiber", "Supports heart health")
                        ),
                        ProductDetails(
                            id = 5,
                            productName = "Strawberry",
                            productSubtitle = "$5.00/dozen",
                            productImageRes = R.drawable.straberry,
                            price = "$5.00",
                            calories = "89 Calories",
                            rating = "4.6",
                            reviewCount = 210,
                            discountPercent = "-15%",
                            description = "Sweet bananas, a great source of potassium and quick energy.",
                            highlights = listOf("Rich in potassium", "Boosts energy levels")
                        ),
                        ProductDetails(
                            id = 6,
                            productName = "Pineapple",
                            productSubtitle = "$17.00/kg",
                            productImageRes = R.drawable.pineapple,
                            price = "$17.20",
                            calories = "47 Calories",
                            rating = "4.5",
                            reviewCount = 256,
                            discountPercent = "-55%",
                            description = "Juicy yellow oranges, packed with Vitamin C and antioxidants.",
                            highlights = listOf("Provides more vitamin C than an orange", "High levels of antioxidants")
                        )
                    ),

                    "Electronics" to listOf(
                        ProductDetails(
                            id = 1,
                            productName = "Camera",
                            productSubtitle = "DSLR Camera",
                            productImageRes = android.R.drawable.ic_menu_camera,
                            price = "$299.99",
                            calories = "N/A",
                            rating = "4.8",
                            reviewCount = 540,
                            discountPercent = "-20%",
                            description = "High quality DSLR camera for professional photography.",
                            highlights = listOf("24MP resolution", "WiFi enabled", "Full HD video recording")
                        )
                    )
                    // Add other categories similarly
                )

                val selectedItem = sampleProductDetails[categoryName]?.find { it.id == itemId }

                val sampleReviews = listOf(
                    Review("Alice", "Great product! Very useful and high quality."),
                    Review("Bob", "It was okay, but shipping took too long."),
                    Review("Charlie", "Excellent! I use it every day."),
                    Review("Diana", "Not worth the price in my opinion."),
                    Review("Ethan", "Amazing experience, will definitely recommend.")
                )


                selectedItem?.let { item ->
                    var quantity by remember { mutableStateOf(1) }
                    ProductDetailsScreen(
                        productName = item.productName,
                        productSubtitle = "${item.price}/kg",
                        productImageRes = item.productImageRes,
                        price = "${item.price}",
                        calories = "14 Calories",
                        rating = "4.5",
                        reviewCount = sampleReviews.size,
                        discountPercent = "-55%",
                        description = "Lorem ipsum dolor sit amet...",
                        highlights = listOf("Provides more vitamin C than an orange", "High levels of antioxidants"),
                        reviews = sampleReviews,
                        quantity = quantity,
                        onQuantityChange = { newQty ->if (newQty > 0) {
                            quantity = newQty
                        } /* update ViewModel/cart */ },
                        onAddToCart = { /* add item to cart */ }
                    )
                }
            }
        }
    }
}

