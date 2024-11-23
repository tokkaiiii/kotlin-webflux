package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST

fun main(){
    val replaySink = Sinks.many().replay().limit<Int>(2)
    val fluxView = replaySink.asFlux()

    replaySink.emitNext(1, FAIL_FAST)
    replaySink.emitNext(2, FAIL_FAST)
    replaySink.emitNext(3, FAIL_FAST)

    fluxView.subscribe { onNext("Subscriber1",it) }
    fluxView.subscribe { onNext("Subscriber2",it) }
}