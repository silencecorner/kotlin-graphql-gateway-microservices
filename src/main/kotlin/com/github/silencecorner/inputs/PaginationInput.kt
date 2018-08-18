package com.github.silencecorner.inputs

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/18 4:31 PM
 */
/*
input PaginationInput {
    skip: Int
    take: Int
}

input AccountInput {
    name: String!
}

input ProductInput {
    name: String!
    description: String!
    price: Float!
}

input OrderProductInput {
    id: String!
    quantity: Int!
}

input OrderInput {
    accountId: String!
    products: [OrderProductInput!]!
}*/

data class PaginationInput(val skip: Int, val take: Int)