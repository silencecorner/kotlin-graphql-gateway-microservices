package com.github.silencecorner.scalar

import graphql.language.FloatValue
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import java.math.BigDecimal

class GraphQLMoney : GraphQLScalarType("Money", "Money", object : Coercing<Double, Double> {
    fun convertImpl(input: Any): Double? = when (input) {
        is FloatValue -> input.value.toDouble()
        is Number -> input.toDouble()
        is StringValue ->
            try {
                BigDecimal(input.value).toDouble()
            } catch (e : NumberFormatException) {
                null
            }
        else -> throw CoercingSerializeException("Invalid value '".plus(input).plus("' for Money"))
    }

    override fun serialize(input: Any): Double? = convertImpl(input)

    override fun parseValue(input: Any): Double? = convertImpl(input)

    override fun parseLiteral(input: Any): Double? = convertImpl(input)
})
