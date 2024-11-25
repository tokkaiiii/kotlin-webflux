package com.reactor.kotlinwebflux.day07.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"
    val mono = Mono.deferContextual { ctx ->
        Mono.just("ID: ${ctx.get<String>(key1)}")
    }.publishOn(Schedulers.parallel())

    mono.contextWrite { it.put(key1,"[ID11111]") }
        .subscribe { onNext("subscriber 1",it) }

    mono.contextWrite{ it.put(key1,"[ID22222]") }
        .subscribe { onNext("subscriber 2",it) }

    Thread.sleep(100)
}