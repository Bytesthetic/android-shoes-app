package com.bytesthetic.shoesapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytesthetic.shoesapp.R
import com.bytesthetic.shoesapp.model.ProductUiModel
import com.bytesthetic.shoesapp.theme.Accent
import com.bytesthetic.shoesapp.theme.DarkText
import com.bytesthetic.shoesapp.theme.ExtraLightText
import com.bytesthetic.shoesapp.theme.Product_1
import com.bytesthetic.shoesapp.theme.RegularText

@Composable
fun ProductSmallCard(
    modifier: Modifier = Modifier,
    product: ProductUiModel,
    onProductClick: (ProductUiModel) -> Unit,
    onAddToCartClick: (ProductUiModel) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clickable(
                onClick = { onProductClick(product) },
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true)
            )
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(16.dp))
            .background(Color.White)
    ) {
        Row {
            Image(
               modifier = Modifier
                   .align(Alignment.CenterVertically)
                   .padding(horizontal = 22.dp, vertical = 2.dp)
                   .size(90.dp),
                painter = painterResource(id = product.imageResource),
                contentDescription = "Product Image"
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Start),
                    text = "Product ${product.name}",
                    color = RegularText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 2.dp)
                        .padding(end = 18.dp),
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting",
                    color = ExtraLightText,
                    fontSize = 10.sp,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 14.dp)
                        .padding(end = 18.dp),
                    text = "$${product.price}",
                    color = DarkText,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .width(2.dp)
                .fillMaxHeight()
                .background(product.color)
        )

        Icon(
            modifier = Modifier
                .clickable(onClick = { onAddToCartClick(product) })
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .background(color = Accent, shape = RoundedCornerShape(12.dp))
                .padding(10.dp)
                .size(16.dp),
            imageVector = Icons.Rounded.ShoppingCart,
            contentDescription = "Cart",
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductSmallCardPreview() {
    ProductSmallCard(
        modifier = Modifier.padding(20.dp),
        product = ProductUiModel(
            imageResource = R.drawable.s_1,
            color = Product_1,
            name = "SA",
            price = 128.99f,
            oldPrice = 168.99f,
        ),
        onProductClick = {},
        onAddToCartClick = {}
    )
}