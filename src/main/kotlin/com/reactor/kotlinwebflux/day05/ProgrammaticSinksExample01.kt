package com.reactor.kotlinwebflux.day05

import com.reactor.kotlinwebflux.util.info
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import reactor.core.publisher.Sinks
import reactor.core.publisher.Sinks.EmitFailureHandler.*
import reactor.core.scheduler.Schedulers
import java.util.stream.IntStream

fun main() = runBlocking<Unit> {
    val tasks = 6
    val unicastSink: Sinks.Many<String> = Sinks.many().unicast().onBackpressureBuffer()
    val fluxView = unicastSink.asFlux()
    IntStream
        .range(1, tasks)
        .forEach {
            launch {
                unicastSink.emitNext(doTask(it), FAIL_FAST)
                info("# emitted: $it")
            }
        }
    delay(100)
    launch {

        fluxView
            .publishOn(Schedulers.parallel())
            .map { "$it success!" }
            .doOnNext { info("# map(): $it") }
            .publishOn(Schedulers.parallel())
            .subscribe { info("# onNext: $it") }
    }
    delay(200)
}

private fun doTask(taskNumber: Int) = "task $taskNumber result"