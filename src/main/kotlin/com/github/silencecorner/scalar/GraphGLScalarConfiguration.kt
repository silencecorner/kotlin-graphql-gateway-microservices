package com.github.silencecorner.scalar

import com.coxautodev.graphql.tools.SchemaParserOptions
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.oembedler.moon.graphql.boot.GraphQLJavaToolsAutoConfiguration
import org.springframework.boot.autoconfigure.AutoConfigureBefore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * @author hai
 * description
 * email hilin2333@gmail.com
 * date 2018/8/19 11:22 AM
 */
@Configuration
@AutoConfigureBefore(GraphQLJavaToolsAutoConfiguration::class)
class GraphGLScalarConfiguration {
    @Bean
    fun graphGLUnixTime(): GraphGLUnixTime {
        return GraphGLUnixTime()
    }

    @Bean
    fun graphGLMoney(): GraphQLMoney {
        return GraphQLMoney()
    }

    @Bean
    fun schemaParserOptions(): SchemaParserOptions {
        return SchemaParserOptions.newOptions()
                .objectMapperConfigurer { mapper, _ ->
                    mapper.registerModule(JavaTimeModule())
                            ?.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                }
                .build()
    }

}