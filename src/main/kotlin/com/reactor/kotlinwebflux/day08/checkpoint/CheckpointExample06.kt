package com.reactor.kotlinwebflux.day08.checkpoint

import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux

fun main() {
    Flux.just(2, 4, 6, 8)
        .zipWith(Flux.just(1, 2, 3, 0)){ x, y -> x / y}
        .checkpoint("CheckpointExample02.zipWith.checkpoint",true)
        .map { it + 2 }
        .checkpoint("CheckpointExample02.map.checkpoint",true)
        .subscribe({ onNext(it) },{ onError(it) })
}