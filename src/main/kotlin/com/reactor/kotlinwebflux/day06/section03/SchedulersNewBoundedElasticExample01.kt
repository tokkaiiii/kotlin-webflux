package com.reactor.kotlinwebflux.day06.section03

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main(){
    val scheduler = Schedulers.newBoundedElastic(2,2,"I/O-Thread")
    val mono = Mono.just(1).subscribeOn(scheduler)
    info("# Start")

    mono.subscribe{
        onNext("subscribe 1 doing",it)
        Thread.sleep(3000)
        onNext("subscribe 1 done",it)
    }

    mono.subscribe{
        onNext("subscribe 2 doing",it)
        Thread.sleep(3000)
        onNext("subscribe 2 done",it)
    }

    mono.subscribe{
        onNext("subscribe 3 doing",it)
    }

    mono.subscribe{
        onNext("subscribe 4 doing",it)
    }

    mono.subscribe{
        onNext("subscribe 5 doing",it)
    }

    mono.subscribe{
        onNext("subscribe 6 doing",it)
    }
}