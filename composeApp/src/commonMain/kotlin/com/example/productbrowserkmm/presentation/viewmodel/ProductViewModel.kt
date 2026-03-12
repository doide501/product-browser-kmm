package com.example.productbrowserkmm.presentation.viewmodel

import com.example.productbrowserkmm.domain.model.Product
import com.example.productbrowserkmm.domain.usecase.GetProductsUseCase
import com.example.productbrowserkmm.domain.usecase.SearchProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(

    private val getProducts: GetProductsUseCase,
    private val searchProducts: SearchProductsUseCase

) {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(ProductUiState())
    val state: StateFlow<ProductUiState> = _state

    fun loadProducts() {

        scope.launch {

            _state.value = ProductUiState(loading = true)

            try {

                val products = getProducts()

                _state.value = ProductUiState(
                    products = products
                )

            } catch (e: Exception) {

                _state.value = ProductUiState(
                    error = e.message
                )
            }
        }
    }

    fun search(query: String) {

        scope.launch {

            if (query.isEmpty()) {
                loadProducts()
                return@launch
            }

            _state.value = ProductUiState(loading = true)

            try {

                val products = searchProducts(query)

                _state.value = ProductUiState(
                    products = products
                )

            } catch (e: Exception) {

                _state.value = ProductUiState(
                    error = e.message
                )
            }
        }
    }
}