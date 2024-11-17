package com.reactor.kotlinwebflux.day02.flux

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Flux

fun fluxExample02() {
    Flux.fromIterable(listOf(1, 2, 3, 4, 5))
        .filter { it > 2 }
        .map { it * 2 }
        .subscribe { info(it) }
}