package com.github.silencecorner.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import com.github.silencecorner.clients.OrderClient
import com.github.silencecorner.types.Account
import com.github.silencecorner.types.Order
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/18 4:12 PM
 */
@Component
class AccountResolver(private val orderClient: OrderClient): GraphQLResolver<Account>{

    fun orders(account: Account): List<Order> ? {
        return Collections.emptyList<Order>()
    }
}