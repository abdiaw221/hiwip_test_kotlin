package com.test.kiwip.controllers

import com.test.kiwip.utils.FizzBuzzService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("kiwipirobot")
class KiwiRobotController(private val fizzBuzzService: FizzBuzzService) {

    @GetMapping
    fun optimised(
        @RequestParam(defaultValue = "") inputString: String
    ): Map<String, Any> {
        val digits = inputString.map { it.toString().toInt() }
        val maxSizeBox = 10
        val sizePacked = 3
        val noOptimisedList = fizzBuzzService.noOptimisedList(digits, maxSizeBox, sizePacked)


        return mapOf(
            "inputString" to inputString,
            "inputStringNonOptimised" to noOptimisedList,
            "inputStringOptimised" to "",
        )
    }
}