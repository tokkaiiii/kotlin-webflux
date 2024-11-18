package com.reactor.kotlinwebflux.day03

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Flux

fun coldSequence() {
    val coldFlux = Flux.fromIterable(listOf(1, 2, 3, 4, 5))
        .map { it * 2 }

    coldFlux.subscribe { info("# Subscriber1: $it") }

    coldFlux.subscribe { info("# Subscriber2: $it") }

}

fun main() {
    coldSequence()
}