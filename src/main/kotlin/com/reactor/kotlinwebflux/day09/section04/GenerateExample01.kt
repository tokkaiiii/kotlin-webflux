package com.reactor.kotlinwebflux.day09.section04

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux
        .generate({0}){state,sink ->
            sink.next(state)
            if (state == 10){
                sink.complete()
            }
            state + 1
        }.subscribe { onNext(it) }
}