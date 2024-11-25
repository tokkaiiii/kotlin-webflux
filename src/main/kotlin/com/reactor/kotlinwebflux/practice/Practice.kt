package com.reactor.kotlinwebflux.practice

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.onComplete
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep

fun main() {
    Flux.fromIterable(1..8 step 2)
        .subscribeOn(Schedulers.boundedElastic())
        .doOnNext { doOnNext("fromIterable", it) }
        .filter { it > 3 }
        .doOnNext { doOnNext("filter", it) }
        .map { it * 10 }
        .doOnNext { doOnNext("map", it) }
        .subscribe { onNext(it)  }

    sleep(500)
}