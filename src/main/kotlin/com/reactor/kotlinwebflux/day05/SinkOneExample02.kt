package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.*

fun main(){
    val sinkOne = Sinks.one<String>()
    val mono = sinkOne.asMono()

    sinkOne.emitValue("Hello Reactor", FAIL_FAST)

    sinkOne.emitValue("Hi Reactor", FAIL_FAST)

    mono.subscribe{ onNext("Subscriber1",it)}
    mono.subscribe{ onNext("Subscriber2",it)}
}