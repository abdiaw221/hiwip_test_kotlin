package com.test.kiwip

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KiwipApplication

fun main(args: Array<String>) {
    runApplication<KiwipApplication>(*args)
}
