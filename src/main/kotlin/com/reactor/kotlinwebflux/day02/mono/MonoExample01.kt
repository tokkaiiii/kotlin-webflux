package com.reactor.kotlinwebflux.day02.mono

import com.reactor.kotlinwebflux.util.info
import reactor.core.publisher.Mono

fun monoExample01(){
    Mono.just("Hello Mono")
        .subscribe{ info(it)}
}