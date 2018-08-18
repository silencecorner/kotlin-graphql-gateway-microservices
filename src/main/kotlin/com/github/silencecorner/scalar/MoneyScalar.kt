package com.github.silencecorner.scalar

import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class MoneyScalar : GraphQLScalarType {
    constructor() : super("Money", "Money", object : Coercing<Double, Double> {
        fun convertImpl(input: Any): Double? = when (input) {
            is Number -> BigDecimal(input.toDouble()).toDouble()
            is StringValue ->
                try {
                    BigDecimal(input.toString()).toDouble()
                } catch (e: NumberFormatException) {
                    null
                }
            else -> throw CoercingSerializeException("Invalid value '".plus(input).plus("' for Money"))
        }

        override fun serialize(input: Any): Double? = convertImpl(input)

        override fun parseValue(input: Any): Double? = convertImpl(input)

        override fun parseLiteral(input: Any): Double? = convertImpl(input)
    })
}