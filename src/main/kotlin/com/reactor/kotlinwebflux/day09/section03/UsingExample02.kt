package com.reactor.kotlinwebflux.day09.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val file = File("test.txt")
    val path = Paths.get(file.absolutePath)

    Flux
        .using(
            { Files.lines(path)},
            {Flux.fromStream(it)},
            {it.close()}
        ).subscribe { onNext(it) }
}