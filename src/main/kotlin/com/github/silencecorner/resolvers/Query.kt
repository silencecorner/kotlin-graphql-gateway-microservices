package com.github.silencecorner.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.github.silencecorner.types.Account
import com.github.silencecorner.types.Product
import graphql.relay.Connection
import graphql.relay.SimpleListConnection
import graphql.schema.DataFetchingEnvironment
import org.apache.commons.lang3.RandomUtils
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*


/**
 * @author hai
 * description 根节点定义查询
 * email hilin2333@gmail.com
 * date 2018/8/18 3:44 PM
 */
@Component
class Query: GraphQLQueryResolver {
    fun accounts(fist: Int?,after: String?, id: String?,env: DataFetchingEnvironment): Connection<Account>? {
        var count = 0
        val accounts = ArrayList<Account>(1000)
        while (count < 1001) {
            accounts.add(Account(count.toString(), "name#$count"))
            count++
        }

        return SimpleListConnection(accounts).get(env)
    }
    fun products(first: Int?,after: String?, query: String?, id: String?,env: DataFetchingEnvironment): Connection<Product> ?{
        var count = 0
        val products = ArrayList<Product>(1000)
        while (count < 1001) {
            products.add(Product(count.toString(), "name#$count","description#$$count",RandomUtils.nextDouble(), LocalDateTime.now()))
            count++
        }
        return SimpleListConnection(products).get(env)
    }
}
