package com.example.kuiper.utils

import kotlin.random.Random

class Utils {

    // Generate random string
    companion object {
        private val STRING_LENGTH = 16
        private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        fun generateRandomString() = (1..STRING_LENGTH)
            .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
            .joinToString("")
    }
}