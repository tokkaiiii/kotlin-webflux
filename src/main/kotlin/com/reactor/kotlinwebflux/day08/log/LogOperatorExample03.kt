package com.reactor.kotlinwebflux.day08.log

import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep

fun main() {
    Flux.fromIterable(fruitsList)
        .subscribeOn(Schedulers.boundedElastic())
        .log("Fruit.Source")
        .publishOn(Schedulers.parallel())
        .map { fruit -> fruit.lowercase() }
        .log("Fruit.Lower")
        .map { fruit -> fruit.substring(0, fruit.length -1) }
        .log("Fruit.Substring")
        .map { fruitName -> fruitsMap[fruitName] }
        .log("Fruit.Name")
        .subscribe({ onNext(it!!) },{ onError(it) })

    sleep(100)
}