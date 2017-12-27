package com.iqmsoft.kotlin

import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long> {

	fun findByLastName(lastName: String): Iterable<Person>
}
