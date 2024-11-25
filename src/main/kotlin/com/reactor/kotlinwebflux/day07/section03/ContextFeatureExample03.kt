package com.reactor.kotlinwebflux.day07.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"
    Mono.deferContextual { ctx ->
        Mono.just("ID: ${ctx.get<String>(key1)}")
    }.publishOn(Schedulers.parallel())
        .contextWrite{it.put(key1,"Key1 Value")}
        .contextWrite{it.put(key1,"Key2 Value")}
        .subscribe { onNext(it) }

    Thread.sleep(100)
}