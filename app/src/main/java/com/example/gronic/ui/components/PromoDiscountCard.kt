package com.example.gronic.ui.components

import androidx.compose.ui.tooling.preview.Preview
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.gronic.R

@Composable
fun PromoDiscountCard(
    modifier: Modifier = Modifier,
    discountText: String = "30% Discount",
    subtitle: String = "Order any food from app and get the discount",
    ctaText: String = "Order Now",
    onCtaClick: () -> Unit = {},
    containerColor: Color = Color(0xFFCDEFD9),
    contentColor: Color = Color(0xFF0F5132),
    @DrawableRes illustrationRes: Int? = null,
) {
    Surface(
        color = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 0.dp,
        shadowElevation = 0.dp,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(min = 92.dp) // close to the reference height
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Illustration (left)
            Box(
                modifier = Modifier
                    .size(100.dp)
            ) {
                if (illustrationRes != null) {
                    Image(
                        painter = painterResource(id = illustrationRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                } else {

                    Text(
                        text = "🥗",
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .alpha(0.9f)
                    )
                }
            }

            Spacer(Modifier.width(12.dp))

            // Texts + CTA (right)
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = discountText,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(2.dp))

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(8.dp))

                TextButton(
                    onClick = onCtaClick,
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = ctaText,
                        style = MaterialTheme.typography.labelLarge,
                        color = contentColor
                    )
                    Spacer(Modifier.width(6.dp))
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF3F5F7)
private fun PromoDiscountCardPreview() {
    MaterialTheme(colorScheme = lightColorScheme()) {
        PromoDiscountCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            illustrationRes = R.drawable.ic_launcher_background,
            onCtaClick = {}
        )
    }
}

