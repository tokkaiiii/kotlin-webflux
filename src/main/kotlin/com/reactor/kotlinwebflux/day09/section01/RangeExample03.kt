package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.common.fruits
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .range(2,2)
        .map { fruits[it] }
        .subscribe { onNext("${it.t1} 은 ${it.t2} 원 이다") }
}