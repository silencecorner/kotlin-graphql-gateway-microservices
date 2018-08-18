package com.github.silencecorner.types

import java.time.LocalDateTime

data class Order(val id: String, val createdAt: LocalDateTime, val totalPrice: Double)