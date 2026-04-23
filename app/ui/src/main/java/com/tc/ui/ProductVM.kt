package com.tc.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.domain.GetProductsUseCase
import com.tc.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class ProductVM (private val  getProductsUseCase: GetProductsUseCase): ViewModel (){
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()


    fun loadProducts() {
        viewModelScope.launch {
           val list   = getProductsUseCase()
            _products.update {
                list
            }

        }

    }


}