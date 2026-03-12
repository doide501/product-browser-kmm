package com.example.productbrowserkmm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.productbrowserkmm.data.remote.ProductApi
import com.example.productbrowserkmm.data.repository.ProductRepositoryImpl
import com.example.productbrowserkmm.domain.model.Product
import com.example.productbrowserkmm.domain.usecase.GetProductsUseCase
import com.example.productbrowserkmm.domain.usecase.SearchProductsUseCase
import com.example.productbrowserkmm.network.createHttpClient
import com.example.productbrowserkmm.presentation.theme.ProductBrowserTheme
import com.example.productbrowserkmm.presentation.ui.ProductDetailScreen

import com.example.productbrowserkmm.presentation.ui.ProductListScreen


import com.example.productbrowserkmm.presentation.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ProductBrowserTheme {

            val client = createHttpClient()
            val api = ProductApi(client)
            val repo = ProductRepositoryImpl(api)

            val viewModel = remember {
                ProductViewModel(
                    GetProductsUseCase(repo),
                    SearchProductsUseCase(repo)
                )
            }

            var selectedProduct by remember {
                mutableStateOf<Product?>(null)
            }

            if (selectedProduct == null) {

                ProductListScreen(
                    viewModel = viewModel,
                    onProductClick = {
                        selectedProduct = it
                    }
                )

            } else {

                ProductDetailScreen(
                    product = selectedProduct!!,
                    onBack = {
                        selectedProduct = null
                    }
                )
            }
        }}
        }







    }


@Preview
@Composable
fun AppAndroidPreview() {
    App()
}