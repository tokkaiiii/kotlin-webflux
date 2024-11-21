package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.doOnRequest
import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux
import java.lang.Thread.*

fun main() {
    Flux.range(1, 5)
        .doOnNext { doOnNext(it) }
        .doOnRequest { doOnRequest(it) }
        .subscribe(object : BaseSubscriber<Int>() {
            override fun hookOnSubscribe(subscription: Subscription) {
                request(1)
            }


            override fun hookOnNext(value: Int) {
                sleep(500L)
                com.reactor.kotlinwebflux.util.onNext(value)
                request(1)
            }
        }
        )
}