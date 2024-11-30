package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.common.fruits
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .fromStream(fruits.stream())
        .subscribe{ onNext(it)}
}