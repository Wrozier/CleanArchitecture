package com.tc.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tc.cleanarchitecture.ui.theme.CleanArchitectureTheme
import com.tc.data.ProductRepositoryImpl
import com.tc.domain.GetProductsUseCase
import com.tc.domain.ProductRepository
import com.tc.ui.ProductScreen
import com.tc.ui.ProductVM

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val productVM = ProductVM(GetProductsUseCase(ProductRepositoryImpl()))

        setContent {
            CleanArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = {
                        productVM.loadProducts()
                    }) {
                    Text("Load data")
                }
            }
            ) { innerPadding ->
                ProductScreen(
                        modifier = Modifier.padding(innerPadding),
                        productVM
                    )
                }
            }
        }
    }
}