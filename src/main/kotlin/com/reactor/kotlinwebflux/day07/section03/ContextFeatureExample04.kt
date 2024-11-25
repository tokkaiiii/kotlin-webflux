package com.reactor.kotlinwebflux.day07.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

fun main() {
    val key1 = "id"
    Mono.just("Name value")
        .flatMap {
            Mono.deferContextual { ctx ->
                Mono.just("${ctx.get<String>(key1)}, $it")
            }.transformDeferredContextual { mono, innerCtx ->
                mono.map {
                    "$it, ${
                        innerCtx.get<String>("job")
                    }"
                }
            }
                .contextWrite { context -> context.put("job", "Software Engineering") }
        }.publishOn(Schedulers.parallel())
        .contextWrite { context -> context.put(key1,"Key1 Value") }
        .subscribe { onNext(it) }

    Thread.sleep(100)
}