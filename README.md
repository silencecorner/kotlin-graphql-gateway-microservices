# kotlin-graphql-gateway-microservices
https://outcrawl.com/go-graphql-gateway-microservices/

### 使用的libs
[starter](https://github.com/graphql-java/graphql-spring-boot)以及[graphql-java-tools](https://github.com/graphql-java/graphql-java-tools)
```
compile "com.graphql-java:graphql-spring-boot-starter:${graphqlVersion}"
compile "com.graphql-java:graphiql-spring-boot-starter:${graphqlVersion}" 
compile "com.graphql-java:graphql-java-tools:${graphqlJavaToolsVersion}"
```
```
rootProject.ext.graphqlVersion = '5.0.3'
rootProject.ext.graphqlJavaToolsVersion = "5.3.1"
```
### 定义scalar
#### *.graphqls文件中定义
```
scalar UnixTime
scalar Money
```
#### UnixTime定义
```
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
```

#### Money定义
```
@Component
class MoneyScalar : GraphQLScalarType("Money", "Money", object : Coercing<Double, Double> {
    fun convertImpl(input: Any): Double? = when (input) {
        is Number -> BigDecimal(input.toDouble()).toDouble()
        is StringValue ->
            try {
                BigDecimal(input.toString()).toDouble()
            } catch (e : NumberFormatException) {
                null
            }
        else -> throw CoercingSerializeException("Invalid value '".plus(input).plus("' for Money"))
    }

    override fun serialize(input: Any): Double? = convertImpl(input)

    override fun parseValue(input: Any): Double? = convertImpl(input)

    override fun parseLiteral(input: Any): Double? = convertImpl(input)
})
```
### TODO 使用grpc实现microservice、resolver定义、解析规则说明、kotlin异步编程