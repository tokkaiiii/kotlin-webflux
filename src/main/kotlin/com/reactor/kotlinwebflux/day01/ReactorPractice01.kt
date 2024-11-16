package com.reactor.kotlinwebflux.day01

import reactor.core.publisher.Flux

fun main() {
    Flux.just(1, 2, 3, 4, 5)
        .map { it * 2 }
        .subscribe { println(it) }
}
