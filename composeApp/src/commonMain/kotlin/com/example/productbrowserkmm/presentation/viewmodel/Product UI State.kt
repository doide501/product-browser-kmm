package com.example.productbrowserkmm.presentation.viewmodel

import com.example.productbrowserkmm.domain.model.Product

data class ProductUiState(

    val loading: Boolean = false,

    val products: List<Product> = emptyList(),

    val error: String? = null

)