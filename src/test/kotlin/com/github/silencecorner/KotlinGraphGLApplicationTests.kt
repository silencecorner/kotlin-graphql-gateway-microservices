package com.github.silencecorner

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class KotlinGraphGLApplicationTests {

	@Test
	fun contextLoads() {
	}

	data class Ticket(
			var contact_email: String? = null,
			var date_opened: LocalDateTime? = null
	)
	@Autowired
	lateinit var mapper: ObjectMapper
	@Test
	fun checkSerialize() {
		val ticket = mapper.readValue(inputJsonString, Ticket::class.java)
		assert ("$ticket" == "Ticket(contact_email=contact@ema.il, date_opened=2017-11-13T06:40)")
	}

	val inputJsonString = """{
        "contact_email": "contact@ema.il",
        "date_opened": "2017-11-13T06:40:00Z"
    }""".trimIndent()

}
