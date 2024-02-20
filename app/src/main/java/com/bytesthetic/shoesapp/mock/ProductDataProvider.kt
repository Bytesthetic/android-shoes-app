package com.bytesthetic.shoesapp.mock

import androidx.compose.ui.graphics.Color
import com.bytesthetic.shoesapp.R
import com.bytesthetic.shoesapp.model.ProductUiModel
import com.bytesthetic.shoesapp.theme.Product_1
import com.bytesthetic.shoesapp.theme.Product_2
import com.bytesthetic.shoesapp.theme.Product_3
import com.bytesthetic.shoesapp.theme.Product_4
import com.bytesthetic.shoesapp.theme.Product_5
import com.bytesthetic.shoesapp.theme.Product_6
import com.bytesthetic.shoesapp.theme.Product_7
import com.bytesthetic.shoesapp.theme.Product_8
import kotlin.random.Random


fun generateProducts(): List<ProductUiModel> {
    val productList = mutableListOf<ProductUiModel>()
    val drawableMap = HashMap<Int, Pair<Int, Color>>()
    val fallbackResource = Pair(R.drawable.s_1, Color.Gray)

    drawableMap[1] = Pair(R.drawable.s_1, Product_1)
    drawableMap[2] = Pair(R.drawable.s_2, Product_2)
    drawableMap[3] = Pair(R.drawable.s_3, Product_3)
    drawableMap[4] = Pair(R.drawable.s_4, Product_4)
    drawableMap[5] = Pair(R.drawable.s_5, Product_5)
    drawableMap[6] = Pair(R.drawable.s_6, Product_6)
    drawableMap[7] = Pair(R.drawable.s_7, Product_7)
    drawableMap[8] = Pair(R.drawable.s_8, Product_8)

    for (i in 1..8) {
        val price = Random.nextInt(100, 999) + .99f

        productList.add(
            ProductUiModel(
                imageResource = drawableMap[i]?.first ?: fallbackResource.first,
                color = drawableMap[i]?.second ?: fallbackResource.second,
                name = "SA",
                price = price,
                oldPrice = price + 80,
            )
        )
    }

    return productList
}

fun generateCategories(): List<String> {
    val categoryList = mutableListOf<String>()

    categoryList.add("Sneakers")
    categoryList.add("Boots")
    categoryList.add("Loafers")
    categoryList.add("Oxfords")
    categoryList.add("Sandals")
    categoryList.add("Flats")

    return categoryList
}