package com.test.kiwip.dao

import com.test.kiwip.domain.FizzBuzz
import com.test.kiwip.repositories.FizzBuzzRepository
import org.springframework.stereotype.Component

@Component
class FizzBuzzDao(private val fizzBuzzRepository: FizzBuzzRepository) {

    fun getFizzBuzzById(id: String) = fizzBuzzRepository.findById(id)

    fun createFizzBuzz(fizzBuzz: FizzBuzz) = fizzBuzzRepository.save(fizzBuzz)

    fun findAllFizzBuzz(): List<FizzBuzz> = fizzBuzzRepository.findAll()

    fun getFizzBuzzByStr(str: String) = findAllFizzBuzz().find { fizz -> str == fizz.str }

    fun getMaxFizzBuzzCounter(): FizzBuzz? = findAllFizzBuzz().maxByOrNull { it -> it.counter }
}