package com.github.silencecorner.types

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/18 3:58 PM
 */
/*type Account {
    id: String!
    name: String!
    orders: [Order!]!
}

type Product {
    id: String!
    name: String!
    description: String!
    price: Float!
}

type Order {
    id: String!
    createdAt: UnixTime!
    totalPrice: Float!
    products: [OrderedProduct!]!
}

type OrderedProduct {
    id: String!
    name: String!
    description: String!
    price: Float!
    quantity: Int!
}*/
data class Product(val id: String, val name: String, val description: String, val price: Double)