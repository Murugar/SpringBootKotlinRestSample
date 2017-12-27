package com.iqmsoft.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.*
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForObject
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
class ApplicationTests(@Autowired private val restTemplate: TestRestTemplate) {

	@Test
	fun findAll() {
		val content = """[{"firstName":"Test1","lastName":"Test1","id":1},{"firstName":"Test2","lastName":"Test2","id":2},{"firstName":"Test3","lastName":"Test3","id":3},{"firstName":"Test4","lastName":"Test4","id":4},{"firstName":"Test5","lastName":"Test5","id":5}]"""
		assertEquals(content, restTemplate.getForObject<String>("/persons"))
	}

}
