package com.example.gronic.domain.model

import androidx.compose.ui.graphics.Color

data class Offer(
    val discountText: String,
    val subtitle: String,
    val ctaText: String,
    val containerColor: Color,
    val contentColor: Color,
    val illustrationRes: Int
)

