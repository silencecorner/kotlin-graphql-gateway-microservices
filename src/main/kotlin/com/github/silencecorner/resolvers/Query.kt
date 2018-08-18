package com.github.silencecorner.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.github.silencecorner.inputs.PaginationInput
import com.github.silencecorner.types.Account
import com.github.silencecorner.types.Product
import org.springframework.stereotype.Component
import java.util.*

/**
 * @author hai
 * description 根节点定义查询
 * email hilin2333@gmail.com
 * date 2018/8/18 3:44 PM
 */
@Component
class Query: GraphQLQueryResolver {
    fun accounts(pagination: PaginationInput, id: String): List<Account> ? {
        return Collections.emptyList()
    }
    fun products(pagination: PaginationInput, query: String, id: String): List<Product> ?{
        return Collections.emptyList()
    }
}