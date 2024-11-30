package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .fromStream(listOf(1, 2, 3, 4, 5).stream())
        .filter { it > 3 }
        .map { it * 2 }
        .subscribe{ onNext(it)}
}