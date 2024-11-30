package com.reactor.kotlinwebflux.common

import reactor.util.function.Tuple2
import reactor.util.function.Tuples

val fruits: List<Tuple2<String,Int>> = listOf(
    Tuples.of("banana",1000),
    Tuples.of("apple",1300),
    Tuples.of("melon",1100),
    Tuples.of("peach",2100)
)