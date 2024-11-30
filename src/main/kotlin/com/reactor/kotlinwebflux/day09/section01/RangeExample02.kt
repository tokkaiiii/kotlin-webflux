package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    val fruitsNames = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    Flux
        .range(0, fruitsNames.size)
        .subscribe { onNext("fruit-name: ${fruitsNames[it]}") }
}