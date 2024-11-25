package com.reactor.kotlinwebflux.day07.section02

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"
    val key2 = "name"
    val key3 = "country"

    Mono.deferContextual { ctx ->
        Mono.just("ID: ${ctx.get<String>(key1)}, Name: ${ctx.get<String>(key2)}, Country: ${ctx.get<String>(key3)}")}
            .publishOn(Schedulers.parallel())
            .contextWrite { it.putAll(Context.of(key2,"[name]",key3,"ko").readOnly()) }
            .contextWrite { it.put(key1,"[id]") }
    .subscribe { onNext(it) }

    Thread.sleep(100)
}