package com.bytesthetic.shoesapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bytesthetic.shoesapp.R
import com.bytesthetic.shoesapp.model.ProductUiModel
import com.bytesthetic.shoesapp.theme.DarkText
import com.bytesthetic.shoesapp.theme.Favorite
import com.bytesthetic.shoesapp.theme.LightText
import com.bytesthetic.shoesapp.theme.Product_1

@Composable
fun ProductBigCard(
    modifier: Modifier = Modifier,
    product: ProductUiModel,
    onProductClick: (ProductUiModel) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    var isFavorite by remember { mutableStateOf(false) }
    val annotatedStr by remember {
        mutableStateOf(
            buildAnnotatedString {
                withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("$${product.oldPrice}")
                }
            }
        )
    }

    Box(
        modifier = modifier
            .clickable(
                onClick = { onProductClick(product) },
                interactionSource = interactionSource,
                indication = rememberRipple(bounded = true)
            )
            .size(168.dp, 210.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.3f)
                .background(color = product.color, shape = RoundedCornerShape(22.dp))
        )

        Text(
           modifier = Modifier
               .padding(horizontal = 6.dp)
               .align(Alignment.TopStart)
               .alpha(0.3f),
            textAlign = TextAlign.Center,
            text = product.number.toString(),
            color = product.color,
            fontSize = 130.sp,
            fontWeight = FontWeight.Black
        )

        Image(
            modifier = Modifier
                .rotate(-25f)
                .size(240.dp)
                .offset(30.dp, (-20).dp),
            painter = painterResource(id = product.imageResource),
            contentDescription = "Product Image"
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart),
            onClick = {
                isFavorite = !isFavorite
            }
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "Favorite",
                tint = if (isFavorite) Favorite else Color.White
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = product.name,
                color = DarkText,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraLight,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "$${product.price}",
                    color = DarkText,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Text(
                    text = annotatedStr,
                    color = LightText,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductBigCardPreview() {
    ProductBigCard(
        modifier = Modifier.padding(20.dp),
        product = ProductUiModel(
            imageResource = R.drawable.s_1,
            color = Product_1,
            name = "SA",
            price = 128.99f,
            oldPrice = 168.99f,
        ),
        onProductClick = {}
    )
}