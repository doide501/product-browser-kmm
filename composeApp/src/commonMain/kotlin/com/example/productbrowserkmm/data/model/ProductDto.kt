package com.example.productbrowserkmm.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(

    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val brand: String? = null,
    val rating: Double,
    val thumbnail: String
)