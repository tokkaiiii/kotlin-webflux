package com.reactor.kotlinwebflux.day08.debugmode

import com.reactor.kotlinwebflux.util.onError
import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks

private val fruits = mutableMapOf<String,String>()

fun main() {
    fruits["banana"] = "바나나"
    fruits["apple"] = "사과"
    fruits["pear"] = "배"
    fruits["grape"] = "포도"

    Hooks.onOperatorDebug()

    Flux.fromIterable(listOf("BANANAS","APPLES","PEARS","MELONS"))
        .map { it.lowercase() }
        .map { it.substring(0,it.length - 1) }
        .map { fruits[it] }
        .map { "맛있는 $it"}
        .subscribe({ onNext(it) },{onError(it)})
}