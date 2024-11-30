package com.reactor.kotlinwebflux.day09.section02

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import java.lang.Thread.*

fun main() {
    info("# Start")

    val mono :Mono<Any> =
        Mono.empty<Any?>()
            .switchIfEmpty(Mono.defer { sayDefault() })

    sleep(3000)
    mono.subscribe { onNext(it) }
}

private fun sayDefault(): Mono<String> {
    info("# sayDefault(): Hi")
    return Mono.just("Hi")
}