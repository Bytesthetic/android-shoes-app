package com.bytesthetic.shoesapp.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bytesthetic.shoesapp.mock.generateProducts
import com.bytesthetic.shoesapp.model.ProductUiModel

@Composable
fun ProductHorizontalList(
    modifier: Modifier = Modifier,
    productList: List<ProductUiModel>,
    onProductClick: (ProductUiModel) -> Unit
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 22.dp),
        horizontalArrangement = Arrangement.spacedBy(36.dp)
    ) {
        items(productList) { product ->
            ProductBigCard(
                product = product,
                onProductClick = { product ->
                    onProductClick(product)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHorizontalListPreview() {
    ProductHorizontalList(
        modifier = Modifier.padding(16.dp),
        productList = generateProducts(),
        onProductClick = {}
    )
}