package com.github.silencecorner.scalar

import graphql.language.IntValue
import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import java.math.BigInteger
import java.time.LocalDateTime
import java.time.ZoneOffset


class GraphGLUnixTime : GraphQLScalarType("UnixTime", "UnixTime", object : Coercing<LocalDateTime, Long> {

    override fun serialize(input: Any): Long? = when (input) {
        is LocalDateTime -> localDateTime2UnixTime(input)
        else -> throw CoercingSerializeException("Invalid value '".plus(input).plus("' for UnixTime"))
    }

    override fun parseValue(input: Any): LocalDateTime? = parseLiteral(input)

    override fun parseLiteral(input: Any): LocalDateTime? = when (input) {
        is IntValue -> unixTime2LocalDateTime(input.value)
        is StringValue -> try {
            unixTime2LocalDateTime(BigInteger(input.value))
        } catch (e: NumberFormatException) {
            null
        }
        else -> null
    }

    fun getChinaZoneOffset(): ZoneOffset = ZoneOffset.of("+8")

    fun unixTime2LocalDateTime(value: BigInteger) = LocalDateTime.ofEpochSecond(value.toLong(), 0, getChinaZoneOffset())


    fun localDateTime2UnixTime(dateTime: LocalDateTime) = dateTime.toEpochSecond(getChinaZoneOffset())

})