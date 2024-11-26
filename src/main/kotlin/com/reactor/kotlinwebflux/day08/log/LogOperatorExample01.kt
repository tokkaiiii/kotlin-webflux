package com.reactor.kotlinwebflux.day08.log

import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux.fromIterable(fruitsList)
        .log()
        .map { fruit -> fruit.lowercase() }
        .map { fruit -> fruit.substring(0, fruit.length -1) }
        .map { fruitName -> fruitsMap[fruitName] }
        .subscribe({ onNext(it!!) },{onError(it)})
}