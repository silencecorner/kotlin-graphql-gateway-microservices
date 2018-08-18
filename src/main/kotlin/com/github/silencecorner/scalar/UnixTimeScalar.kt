package com.github.silencecorner.scalar

import graphql.schema.Coercing
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneOffset

fun getChinaZoneOffset(): ZoneOffset = ZoneOffset.of("+8")

@Component
class UnixTimeScalar : GraphQLScalarType("UnixTime", "UnixTime", object : Coercing<LocalDateTime, Long> {

    override fun serialize(input: Any): Long? = when (input) {
        is LocalDateTime -> input.toEpochSecond(getChinaZoneOffset())
        else -> throw CoercingSerializeException("Invalid value '".plus(input).plus("' for DateTime"))
    }

    override fun parseValue(input: Any): LocalDateTime? = parseLiteral(input)

    override fun parseLiteral(input: Any): LocalDateTime? = when (input) {
        is Long -> LocalDateTime.ofEpochSecond(input, 0, getChinaZoneOffset())
        else -> null
    }
})