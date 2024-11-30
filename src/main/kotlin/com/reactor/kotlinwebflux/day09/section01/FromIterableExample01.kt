package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .fromIterable(listOf(1, 2, 3))
        .subscribe{ onNext(it) }
}