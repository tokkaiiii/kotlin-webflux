package com.reactor.kotlinwebflux.day06.section02

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main(){
    Flux.fromIterable(1..7 step 2)
        .doOnNext { doOnNext("fromIterable",it) }
        .publishOn(Schedulers.parallel())
        .filter { it > 3 }
        .doOnNext { doOnNext("filter",it) }
        .map { it * 10 }
        .doOnNext { doOnNext("map",it) }
        .subscribe { onNext(it) }

    Thread.sleep(500)
}