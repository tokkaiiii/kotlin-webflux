package com.reactor.kotlinwebflux.day06.section03

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers

fun main(){
    doTask("task1")
        .subscribe { onNext(it) }
    doTask("task2")
        .subscribe { onNext(it) }

    Thread.sleep(200)
}

private fun doTask(taskName: String): Flux<Int>{
    return Flux.fromIterable(1..7 step 2)
        .publishOn(Schedulers.single())
        .filter{ it > 3 }
        .doOnNext { doOnNext(taskName,"filter",it) }
        .map { it * 10 }
        .doOnNext { doOnNext(taskName,"map",it) }
}