package com.tc.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    productVM: ProductVM
) {

    val product by productVM.products.collectAsState()

    LazyColumn (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(product.size) {
            Text(text = product[it].title)
            Text(text = product[it].price.toString())
            Text(text = product[it].description)
        }


    }
}
