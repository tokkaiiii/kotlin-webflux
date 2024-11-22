package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.*

fun main(){
    val unicastSink = Sinks.many().unicast().onBackpressureBuffer<Int>()
    val fluxView = unicastSink.asFlux()

    unicastSink.emitNext(1, FAIL_FAST)
    unicastSink.emitNext(2, FAIL_FAST)

    fluxView.subscribe { onNext("Subscriber1",it) }
    unicastSink.emitNext(3, FAIL_FAST)
//    fluxView.subscribe { onNext("Subscriber2",it) }
}