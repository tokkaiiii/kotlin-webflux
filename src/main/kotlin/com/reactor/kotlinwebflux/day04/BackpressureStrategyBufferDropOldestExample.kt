package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.BufferOverflowStrategy.DROP_OLDEST
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
            { info("# Overflow & dropped: $it") },
            DROP_OLDEST
        )
        .doOnNext { info("# emitted by Buffer: $it") }
        .publishOn(Schedulers.parallel(), false, 1)
        .subscribe(
            {
                sleep(1000L)
                onNext(it)
            },
            {
                onError(it)
            }
        )
    sleep(3000L)
}