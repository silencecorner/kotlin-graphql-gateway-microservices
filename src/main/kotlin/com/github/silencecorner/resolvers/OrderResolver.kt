package com.github.silencecorner.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import com.github.silencecorner.clients.OrderProductClient
import com.github.silencecorner.types.Order
import com.github.silencecorner.types.OrderedProduct
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/18 4:12 PM
 */
@Component
class OrderResolver(private val orderProductClient: OrderProductClient): GraphQLResolver<Order>{

    fun products(order: Order): List<OrderedProduct> ? {
        return Collections.emptyList<OrderedProduct>()
    }
}