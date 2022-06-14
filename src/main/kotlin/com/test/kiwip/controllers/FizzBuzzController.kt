package com.test.kiwip.controllers

import com.test.kiwip.dao.FizzBuzzDao
import com.test.kiwip.domain.FizzBuzz
import com.test.kiwip.utils.FizzBuzzService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("fizzbuzz")
class FizzBuzzController(private val fizzBuzzDao: FizzBuzzDao, private val fizzBuzzService: FizzBuzzService) {


    @GetMapping("/all")
    fun getAllFizzBuzz(): ResponseEntity<List<FizzBuzz>> {
        val fizzBuzzList = fizzBuzzDao.findAllFizzBuzz()
        return ResponseEntity.ok(fizzBuzzList)
    }

    @GetMapping("/statistics")
    fun getStatisticsRequest(): Map<String, Any> {
        val fizzBuzzStat = fizzBuzzDao.getMaxFizzBuzzCounter()
        val str = fizzBuzzStat?.str
        val delim = "/"
        val list = str?.split(delim)
        return mapOf(
            "int1" to "" + list?.get(0),
            "int2" to "" + list?.get(1),
            "limit" to "" + list?.get(2),
            "str1" to "" + list?.get(3),
            "str2" to "" + list?.get(4),
            "count" to "" + fizzBuzzStat?.counter,
        )
    }

    @GetMapping
    fun list(
        @RequestParam(defaultValue = "") int1: Int,
        @RequestParam(defaultValue = "") int2: Int,
        @RequestParam(defaultValue = "") limit: Int,
        @RequestParam(defaultValue = "") str1: String,
        @RequestParam(defaultValue = "") str2: String
    ): ResponseEntity<List<String>> {
        val fizzFormatted = "$int1/$int2/$limit/$str1/$str2"
        val search = fizzBuzzDao.getFizzBuzzByStr(fizzFormatted)
        if (search == null) {
            val fizzBuzz = FizzBuzz(
                str = fizzFormatted,
                counter = 1
            )
            fizzBuzzDao.createFizzBuzz(fizzBuzz)
        } else {
            search.counter += 1
            fizzBuzzDao.createFizzBuzz(search)
        }
        return ResponseEntity.ok(fizzBuzzService.formattedList(int1, int2, limit, str1, str2))
    }
}