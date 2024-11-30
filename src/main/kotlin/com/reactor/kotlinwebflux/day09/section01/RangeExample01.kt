package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .range(5,10)
        .subscribe{ onNext(it) }
}