package com.reactor.kotlinwebflux.day03

import com.reactor.kotlinwebflux.util.info
import kotlinx.coroutines.*
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.stream.Stream


val hotFlux = Flux.fromStream(Stream.of("A", "B", "C", "D", "E"))
    .delayElements(Duration.ofSeconds(1)).share()

fun main() = runBlocking<Unit> {
    launch(Dispatchers.IO) {
        hotFlux.subscribe {
            info("# Received 1 $it")
        }
    }
    delay(2500)
    launch(Dispatchers.IO) {
        hotFlux.subscribe {
            info("# Received 1 $it")
        }
    }
    delay(3000)


}