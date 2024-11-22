package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep
import java.time.Duration

fun main() {
    Flux
        .interval(Duration.ofMillis(1L))
        .onBackpressureDrop { info("# dropped: $it", { "backpressure dropped" }) }
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