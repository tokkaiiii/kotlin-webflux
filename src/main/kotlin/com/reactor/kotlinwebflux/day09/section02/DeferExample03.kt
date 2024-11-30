package com.reactor.kotlinwebflux.day09.section02

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import java.time.Duration

fun main() {
    info("# Start")

    Mono
        .just("Hello")
        .delayElement(Duration.ofSeconds(3))
        .switchIfEmpty(Mono.defer { sayDefault() })
        .subscribe { onNext(it) }

    Thread.sleep(3500)
}
private fun sayDefault(): Mono<String> {
    info("# sayDefault(): Hi")
    return Mono.just("Hi")
}