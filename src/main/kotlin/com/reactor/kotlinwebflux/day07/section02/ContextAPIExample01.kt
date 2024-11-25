package com.reactor.kotlinwebflux.day07.section02

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"
    val key2 = "name"
    val mono = Mono.deferContextual { ctx ->
        Mono.just("ID: ${ctx.get<String>(key1)} , Name: ${ctx.get<String>(key2)}")
    }
        .publishOn(Schedulers.parallel())
        .contextWrite(Context.of(key1,"[ID 입력란]" , key2, "[Name 입력란]"))

    mono.subscribe { onNext(it) }

    Thread.sleep(100)
}