package com.reactor.kotlinwebflux.day04

import com.reactor.kotlinwebflux.util.doOnNext
import com.reactor.kotlinwebflux.util.doOnRequest
import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux
import java.lang.Thread.*


fun main(){
    var count = 0
    Flux.range(1, 5)
        .doOnNext{ doOnNext(it) }
        .doOnRequest { doOnRequest(it) }
        .subscribe(object : BaseSubscriber<Int>() {

            override fun hookOnSubscribe(subscription: Subscription) {
                request(2)
            }

            override fun hookOnNext(value: Int) {
                count++
                com.reactor.kotlinwebflux.util.onNext(value)
                if (count == 2) {
                    sleep(2000L)
                    request(2)
                    count = 0
                }
            }

        })
}