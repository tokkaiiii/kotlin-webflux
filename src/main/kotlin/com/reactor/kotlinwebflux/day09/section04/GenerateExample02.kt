package com.reactor.kotlinwebflux.day09.section04

import com.reactor.kotlinwebflux.util.info
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.util.function.Tuples

fun main() {
    Flux
        .generate(
            {Tuples.of(2,1)},
            {state,sink ->
                sink.next("${state.t1} * ${state.t2} = ${state.t1 * state.t2}")
                if (state.t2 ==9){
                    sink.complete()
                }
                Tuples.of(state.t1,state.t2 + 1)
            },
            { info("구구단 ${it.t1}단 종료!") }
        )
        .subscribe { onNext(it) }
}