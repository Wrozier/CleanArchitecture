package com.tc.domain

class GetProductsUseCase(private val productRepository: ProductRepository){
   suspend operator fun invoke(): List<Product> {
        return productRepository.getAllProducts()
    }
}
