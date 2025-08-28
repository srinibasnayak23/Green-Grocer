package com.example.gronic.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.gronic.R
import com.example.gronic.domain.model.Offer
import com.example.gronic.ui.components.PromoDiscountCard
import com.example.gronic.ui.theme.GreenBodyBackground
import com.example.gronic.ui.theme.OffWhiteBodyBackground

//@Composable
//fun OffersScreen() {
//    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//        Text("🎉 Offers Screen")
//    }
//}

@Composable
fun OfferScreen(
    offers: List<Offer>,
    modifier: Modifier = Modifier,
    onOrderNowClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                GreenBodyBackground,
            )

    ) {
        // Fixed Title
        Text(
            text = "Offers",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 34.dp, bottom = 34.dp)
        )

        // Scrollable offers list
        Surface(
            modifier = Modifier
                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
                .background(
                    OffWhiteBodyBackground,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )

                .padding(top = 0.4.dp, start = 24.dp, end = 24.dp),
        ) {
            LazyColumn(
                modifier = Modifier
                    .background(
                        OffWhiteBodyBackground,
                    )
                    .fillMaxSize(),
//                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(top = 16.dp)
            ) {
                items(offers){ offer ->
                    PromoDiscountCard(
                        discountText = offer.discountText,
                        subtitle = offer.subtitle,
                        ctaText = offer.ctaText,
                        onCtaClick = onOrderNowClick,
                        containerColor = offer.containerColor,
                        contentColor = offer.contentColor,
                        illustrationRes = offer.illustrationRes
                    )
                }
            }
        }

        // 30% Discount Card
//        PromoDiscountCard(
//            discountText = "30% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            onCtaClick = onOrderNowClick,
//            containerColor = Color(0xFFCDEFD9),
//            contentColor = Color(0xFF0F5132),
//            illustrationRes = R.drawable.fruits
//        )
//
//        // 15% Discount Card
//        PromoDiscountCard(
//            discountText = "15% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            onCtaClick = onOrderNowClick,
//            containerColor = Color(0xFFFFE2B5),
//            contentColor = Color(0xFF92400E),
//            illustrationRes = R.drawable.fruits
//        )
//
//
//        // 12% Discount Card
//        PromoDiscountCard(
//            discountText = "12% Discount",
//            subtitle = "Order any food from app and get the discount",
//            ctaText = "Order Now",
//            onCtaClick = onOrderNowClick,
//            containerColor = Color(0xFFD9F2E6),
//            contentColor = Color(0xFF0F5132),
//            illustrationRes = R.drawable.fruits
//        )
    }
}

