package com.github.silencecorner.inputs

import java.time.LocalDateTime

data class OrderInput(val accountId: String,val products: List<OrderProductInput>)