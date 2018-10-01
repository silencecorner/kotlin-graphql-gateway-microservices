package com.github.silencecorner.types

import java.time.LocalDateTime

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/18 3:58 PM
 */
data class Product(
        val id: String,
        val name: String,
        val description: String,
        val price: Double,
        val createdAt: LocalDateTime
)