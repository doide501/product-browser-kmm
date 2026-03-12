package com.example.productbrowserkmm.data.remote

import com.example.productbrowserkmm.data.model.ProductDto
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(

    val products: List<ProductDto>
)