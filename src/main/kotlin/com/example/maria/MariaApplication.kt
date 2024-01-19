package com.example.maria

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MariaApplication

fun main(args: Array<String>) {
	runApplication<MariaApplication>(*args)
}
