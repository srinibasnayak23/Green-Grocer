package com.example.gronic.domain.model

data class CategoryListItem(
    val id: Int,
    val name: String,
    val price: Double,
    val offerPrice: Double,
    val imageRes: Int
)