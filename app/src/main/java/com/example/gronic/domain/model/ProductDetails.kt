package com.example.gronic.domain.model

data class ProductDetails(
    val id: Int,
    val productName: String = "Orange - Yellow",
    val productSubtitle: String = "$17.00/kg",
    val productImageRes: Int,
    val price: String = "$17.20",
    val calories: String = "14 Calories",
    val rating: String = "4.5",
    val reviewCount: Int = 256,
    val discountPercent: String = "-55%",
    val description: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
    val highlights: List<String> = listOf(
        "Provides more vitamin C than an orange",
        "High levels of antioxidants"
    ),
    val quantity: Int = 1
)

