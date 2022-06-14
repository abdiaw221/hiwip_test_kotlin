package com.test.kiwip.domain

import lombok.AllArgsConstructor
import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Data
@AllArgsConstructor
@Document(collection = "fizz")
data class FizzBuzz(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val str: String,
    var counter: Int,
)

