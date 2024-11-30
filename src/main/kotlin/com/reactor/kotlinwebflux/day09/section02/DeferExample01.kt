package com.reactor.kotlinwebflux.day09.section02

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux.defer
import reactor.core.publisher.Mono
import java.lang.Thread.sleep
import java.time.OffsetDateTime

fun main() {
    info("# Starting")

    val justMono = Mono.just(OffsetDateTime.now())
    val deferMono = defer { Mono.just(OffsetDateTime.now()) }

    sleep(2000)

    justMono.subscribe { onNext("just1",it) }
    deferMono.subscribe { onNext("defer1",it) }

    sleep(2000)

    justMono.subscribe { onNext("just2",it) }
    deferMono.subscribe { onNext("defer2",it) }
}