package com.reactor.kotlinwebflux.day07.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"
    val key2 = "name"

    Mono.deferContextual { ctx ->
        Mono.just(ctx.get<String>(key1))
    }.publishOn(Schedulers.parallel())
        .contextWrite { it.put(key2, "Key2 Value") }
        .transformDeferredContextual { mono, ctx ->
            mono.map { "$it , ${ctx.getOrDefault<String>(key2,"This is Key2 Default Value")}" }

        }.contextWrite { it.put(key1,"Key1 Value") }
        .subscribe { onNext(it) }

    Thread.sleep(100)

}