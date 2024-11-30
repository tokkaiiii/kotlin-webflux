package com.reactor.kotlinwebflux.day09.section01

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono

fun main() {
    Mono
        .justOrEmpty("hello")
        .log()
        .subscribe{ onNext(it) }
}