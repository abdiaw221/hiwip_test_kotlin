package com.test.kiwip.utils

import org.springframework.stereotype.Service

@Service
class FizzBuzzService {

    fun formattedList(int1: Int, int2: Int, limit: Int, str1: String, str2: String): MutableList<String> {
        val response: MutableList<String> = mutableListOf()
        for (i in 1..limit) {
            var e: String = String.format("%d", i)
            val mod1 = i % int1
            val mod2 = i % int2
            if (mod1 == 0) {
                e = str1
            }
            if (mod2 == 0) {
                e = str2
            }
            if (mod1 == 0 && mod2 == 0) {
                e = str1 + str2
            }
            response.add(e)
        }
        return response
    }


    fun noOptimisedList(boxesChain: List<Int>, maxSizeBox: Int, sizePacked: Int): String {
        val noOptimisedList: MutableList<String> = mutableListOf()
        val chains: MutableList<Int> = mutableListOf()
        var sum = 0

        for (i in boxesChain.indices) {
            sum += boxesChain[i]
            if (sum <= maxSizeBox) {
                chains.add(boxesChain[i])
                if (chains.size <= sizePacked && (boxesChain.size - i + 1) == 2) {
                    val seqOptimised = chains.joinToString("")
                    noOptimisedList.add(seqOptimised)
                    chains.clear()
                    sum = boxesChain[i]
                }
            }
            if (sum > maxSizeBox) {
                val seqOptimised = chains.joinToString("")
                noOptimisedList.add(seqOptimised)
                chains.clear()
                chains.add(boxesChain[i])
                sum = boxesChain[i]
            }
        }
        return noOptimisedList.joinToString("/")
    }

    fun optimisedList(boxesChain: MutableList<Int>, maxSizeBox: Int, sizePacked: Int): String {
        // Not yet
        return ""
    }

}