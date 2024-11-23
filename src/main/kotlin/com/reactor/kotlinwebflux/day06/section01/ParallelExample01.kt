package com.reactor.kotlinwebflux.day06.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main(){
    Flux.fromArray(arrayOf(1,3,5,7,9,11,13,15))
        .parallel()
        .subscribe{ onNext(it)}
}