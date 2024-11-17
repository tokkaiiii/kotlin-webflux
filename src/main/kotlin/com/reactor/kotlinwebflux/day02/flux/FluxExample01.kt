package com.reactor.kotlinwebflux.day02.flux

import reactor.core.publisher.Flux

fun fluxExample01() {
    Flux.just("A", "B", "C", "D", "E", "F")
        .filter{ it > "B" }
        .subscribe { println(it) }
}