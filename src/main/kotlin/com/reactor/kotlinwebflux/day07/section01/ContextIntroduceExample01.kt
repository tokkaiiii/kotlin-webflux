package com.reactor.kotlinwebflux.day07.section01

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key = "massage"
    val mono = Mono.deferContextual { ctx ->
        Mono.just("Hello" + " " + ctx.get(key)).doOnNext { doOnNext(it) }
    }
        .subscribeOn(Schedulers.boundedElastic())
        .publishOn(Schedulers.parallel())
        .transformDeferredContextual { mono2, ctx -> mono2.map { it + " " + ctx.get(key) } }
        .contextWrite { context -> context.put(key, "Reactor") }
    mono.subscribe { onNext(it) }
    Thread.sleep(100)
}