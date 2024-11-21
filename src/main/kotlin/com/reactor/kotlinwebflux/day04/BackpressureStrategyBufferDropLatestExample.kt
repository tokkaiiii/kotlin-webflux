package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.BufferOverflowStrategy.DROP_LATEST
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep
import java.time.Duration

fun main() {
    Flux
        .interval(Duration.ofMillis(300L))
        .doOnNext { info("# emitted by original Flux: $it") }
        .onBackpressureBuffer(
            2,
            { dropped -> info("# Overflow $dropped") },
            DROP_LATEST
        )
        .doOnNext { info("# emitted by Buffer: $it") }
        .publishOn(Schedulers.parallel(), false, 1)
        .subscribe(
            { data ->
                sleep(1000L)
                onNext(data)
            },
            { error ->
                onError(error)
            }
        )
    sleep(3000L)

}