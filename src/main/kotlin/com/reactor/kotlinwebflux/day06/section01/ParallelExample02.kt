package com.reactor.kotlinwebflux.day06.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main(){
    Flux.fromIterable(1..10 step 2)
        .parallel()
        .runOn(Schedulers.parallel())
        .subscribe{ onNext(it) }

    Thread.sleep(100)
}