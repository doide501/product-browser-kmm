package com.example.productbrowserkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform