package com.reactor.kotlinwebflux.day02.mono

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Mono

fun monoExample02() {
    Mono.empty<Any>()
        .subscribe (
            { info("# emitted data: $it")},
            {error(it)},
            { info("# emitted onComplete signal")}
        )
}