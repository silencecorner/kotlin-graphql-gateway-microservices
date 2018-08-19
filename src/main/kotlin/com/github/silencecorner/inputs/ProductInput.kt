package com.github.silencecorner.inputs

import java.time.LocalDateTime

data class ProductInput(
        val name: String,
        val description: String,
        val price: Double? = 0.0,
        val shippingDateTime: LocalDateTime? = LocalDateTime.now()
)