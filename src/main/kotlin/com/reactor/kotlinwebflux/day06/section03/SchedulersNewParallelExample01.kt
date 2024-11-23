package com.reactor.kotlinwebflux.day06.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val flux = Mono.just(1)
        .publishOn(Schedulers.newParallel("Parallel Thread", 4, true))

    flux.subscribe {
        Thread.sleep(5000)
        onNext("subscribe 1", it)
    }

    flux.subscribe {
        Thread.sleep(4000)
        onNext("subscribe 2", it)
    }

    flux.subscribe {
        Thread.sleep(3000)
        onNext("subscribe 3", it)
    }

    flux.subscribe {
        Thread.sleep(2000)
        onNext("subscribe 4", it)
    }

    Thread.sleep(6000)
}