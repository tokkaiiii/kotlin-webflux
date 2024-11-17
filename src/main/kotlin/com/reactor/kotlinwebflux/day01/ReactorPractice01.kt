package com.reactor.kotlinwebflux.day01

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main() {
//    day01Example01()
    day01Example02()
}

fun day01Example01(){
    Flux.just(1, 2, 3, 4, 5)
        .map { it * 2 }
        .subscribe { info(it) }
}

fun day01Example02(){
    Mono.just("mono data")
        .subscribe { info(it) }
}