package com.reactor.kotlinwebflux.practice

import com.reactor.kotlinwebflux.util.*
import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.BufferOverflowStrategy
import reactor.core.publisher.BufferOverflowStrategy.*
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import reactor.core.scheduler.Schedulers.*
import java.lang.Thread.sleep
import java.time.Duration

fun main() {
    Flux.interval(Duration.ofMillis(1L))
        .onBackpressureLatest()
        .publishOn(parallel())
        .subscribe({
            sleep(5)
            onNext(it)
        }, {
            onError(it)
        })
    sleep(2000)
}