package com.example.gronic.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gronic.domain.model.Deal
import com.example.gronic.ui.components.PopularDealCard
import com.example.gronic.ui.components.SectionHeader

@Composable
fun PopularDeal(
    modifier: Modifier,
    deals: List<Deal>,
    onSeeAllClick: () -> Unit,
    onDealClick: (Deal) -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        SectionHeader(
            title = "Popular deals",
            onSeeAllClick = onSeeAllClick
        )

        LazyRow(
            modifier = Modifier.padding(bottom = 8.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(deals) { deal ->
                PopularDealCard(
                    deal = deal,
                    onClick = { onDealClick(deal) }
                )
            }
        }
    }
}
