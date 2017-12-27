package com.iqmsoft.kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(private val repository: PersonRepository) {

	@GetMapping("/persons")
	fun findAll() = repository.findAll()

	@GetMapping("/persons/{lastName}")
	fun findByLastName(@PathVariable lastName:String)
			= repository.findByLastName(lastName)
}