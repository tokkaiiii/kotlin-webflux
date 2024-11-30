package com.reactor.kotlinwebflux.day09.section03

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono

fun main() {
    Mono
        .using(
            {"Resource"},
            { resource -> Mono.just(resource) },
            { resource -> info("cleanup: $resource") }
        ).subscribe { onNext(it) }
}