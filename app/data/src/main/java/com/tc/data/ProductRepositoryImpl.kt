package com.tc.data

import com.tc.domain.Product
import com.tc.domain.ProductRepository
import com.tc.domain.Rating

class ProductRepositoryImpl : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {
        return listOf(
            Product( 1 , "P1", 12f, "Electronic Product", "abc",
                "img", Rating(4f, 120)
            ),
            Product( 2 , "P2", 12f, "Clothes Product", "efg",
                "img", Rating(4f, 120)
            ),
            Product( 3 , "P3", 12f, "Food Product", "hij",
                "img", Rating(4f, 120)
            )
        )



    }
}