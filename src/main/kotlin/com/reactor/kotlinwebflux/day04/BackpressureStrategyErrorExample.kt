package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.lang.Thread.*
import java.time.Duration

fun main() {
    Flux
        .interval(Duration.ofMillis(1L))
        .onBackpressureError()
        .doOnNext { doOnNext(it) }
        .publishOn(Schedulers.parallel())
        .subscribe(
            {
                sleep(5L)
                onNext(it)
            },
            {
                onError(it)
            }
        )
    sleep(2000L)
}