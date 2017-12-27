package com.iqmsoft.kotlin

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

	private val log = LoggerFactory.getLogger(Application::class.java)

	@Bean
	fun init(repository: PersonRepository) = CommandLineRunner {
			// save a couple of persons
			repository.save(Person("Test1", "Test1"))
			repository.save(Person("Test2", "Test2"))
			repository.save(Person("Test3", "Test3"))
			repository.save(Person("Test4", "Test4"))
			repository.save(Person("Test5", "Test5"))

			// fetch all persons
			log.info("Persons found with findAll():")
			log.info("-------------------------------")
			repository.findAll().forEach { log.info(it.toString()) }
			log.info("")

			// fetch an individual person by ID
			val person = repository.findById(1L)
			person.ifPresent {
				log.info("Person found with findOne(1L):")
				log.info("--------------------------------")
				log.info(it.toString())
				log.info("")
			}

			// fetch customers by last name
			log.info("Person found with findByLastName('Test1'):")
			log.info("--------------------------------------------")
			repository.findByLastName("Test5").forEach { log.info(it.toString()) }
			log.info("")
	}

}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
