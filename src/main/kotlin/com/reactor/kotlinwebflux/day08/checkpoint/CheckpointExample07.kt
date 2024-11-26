package com.reactor.kotlinwebflux.day08.checkpoint

import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    val source = Flux.just(2, 4, 6, 8)
    val other = Flux.just(1, 2, 3, 0)

    val multiplySource = divide(source, other).checkpoint()
    val plusSource = plus(multiplySource).checkpoint()

    plusSource.subscribe({ onNext(it) }, { onError(it) })
}

private fun divide(source: Flux<Int>, other: Flux<Int>): Flux<Int> =
    source.zipWith(other) { x, y -> x / y }

private fun plus(source: Flux<Int>) = source.map { it + 2 }