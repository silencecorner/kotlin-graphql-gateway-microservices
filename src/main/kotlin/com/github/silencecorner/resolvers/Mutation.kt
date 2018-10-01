package com.github.silencecorner.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.github.silencecorner.inputs.AccountInput
import com.github.silencecorner.inputs.OrderInput
import com.github.silencecorner.inputs.ProductInput
import com.github.silencecorner.types.Account
import com.github.silencecorner.types.Order
import com.github.silencecorner.types.Product
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

/**
 * @author hai
 * description 修改定义
 * email hilin2333@gmail.com
 * date 2018/8/18 4:44 PM
 */
@Component
class Mutation : GraphQLMutationResolver {
    fun createAccount(account: AccountInput): Account? {
        return null
    }

    fun createProduct(product: ProductInput,env: DataFetchingEnvironment): Product? {
        return Product(
                UUID.randomUUID().toString(),
                product.name,
                product.description,
                product.price?.unaryPlus()
                ?: 0.00,
                LocalDateTime.MIN
        )
    }

    fun createOrder(order: OrderInput): Order? {
        return null
    }
}