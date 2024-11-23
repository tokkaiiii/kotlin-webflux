package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Flux
import reactor.core.publisher.FluxSink
import reactor.core.scheduler.Schedulers
import java.lang.Thread.sleep
import java.util.stream.IntStream

fun main() {
    val tasks = 6
    Flux
        .create { sink: FluxSink<String> ->
            IntStream
                .range(1, tasks)
                .forEach { sink.next(doTask(it)) }
        }
        .subscribeOn(Schedulers.boundedElastic())
        .doOnNext { info("# create(): $it") }
        .publishOn(Schedulers.parallel())
        .map { "$it success!" }
        .doOnNext { info("# map(): $it") }
        .publishOn(Schedulers.parallel())
        .subscribe { info("# onNext: $it") }

    sleep(500)
}

private fun doTask(taskNumber: Int) = "task $taskNumber result"