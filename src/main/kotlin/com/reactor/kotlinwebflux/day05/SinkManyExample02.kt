package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.*

fun main(){
    val multicastSink = Sinks.many().multicast().onBackpressureBuffer<Int>()
    val fluxView = multicastSink.asFlux()

    multicastSink.emitNext(1, FAIL_FAST)
    multicastSink.emitNext(2, FAIL_FAST)

    fluxView.subscribe { onNext("Subscriber1",it) }
    fluxView.subscribe { onNext("Subscriber2",it) }
    multicastSink.emitNext(3, FAIL_FAST)
}