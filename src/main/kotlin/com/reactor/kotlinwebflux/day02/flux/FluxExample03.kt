package com.reactor.kotlinwebflux.day02.flux

import reactor.core.publisher.Mono

fun fluxExample03() {
    val flux = Mono.justOrEmpty<String>(null)
        .concatWith(Mono.justOrEmpty("test"))
    flux.subscribe { println(it) }
}