package com.reactor.kotlinwebflux.day06.section02

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main(){
    Flux.fromIterable(1..7 step 2)
        .filter { it > 3 }
        .map { it * 10 }
        .subscribe { onNext(it) }
}