package com.reactor.kotlinwebflux.day07.section02

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.util.context.Context

fun main() {
    val key1 = "id"
    val key2 = "name"

    Mono.deferContextual { ctx ->
        Mono.just("ID: ${ctx.get<String>(key1)}, Name: ${ctx.get<String>(key2)}, Job: ${ctx.getOrDefault("job","Software Engineering")}")
    }
        .publishOn(Schedulers.parallel())
        .contextWrite(Context.of(key1,"[ID]",key2,"[Name]"))
//        .contextWrite { ctx -> ctx.put("job","Hardware Engineering") }
        .subscribe { onNext(it) }
    Thread.sleep(100)
}