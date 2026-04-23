package com.tc.domain

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
}

