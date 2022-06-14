package com.test.kiwip.repositories

import com.test.kiwip.domain.FizzBuzz
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FizzBuzzRepository : MongoRepository<FizzBuzz, String> {
    override fun deleteAll()
}