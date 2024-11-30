package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.common.fruits
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .fromIterable(fruits)
        .subscribe{fruit -> onNext("과일: ${fruit.t1}, 가격: ${fruit.t2}")}
}