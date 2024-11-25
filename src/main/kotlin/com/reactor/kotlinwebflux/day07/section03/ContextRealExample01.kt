package com.reactor.kotlinwebflux.day07.section03

import com.reactor.kotlinwebflux.util.onNext
import reactor.core.publisher.Mono
import reactor.util.context.Context

private const val HEADER_NAME_AUTH_TOKEN = "authToken"

fun main() {
    val mono = postBook(Mono.just(Book("abcd-1111-3533-2809"
        , "Reactor's Bible"
        ,"author")))
        .contextWrite(Context.of(HEADER_NAME_AUTH_TOKEN,"eyJhbGciOiJIUzUxMiJ9.eyJzdWI"))
    mono.subscribe { onNext(it) }
}

fun postBook(book: Mono<Book>): Mono<String> {
    return Mono.zip(
        book,
        Mono.deferContextual { ctx -> Mono.just(ctx.get<String>(HEADER_NAME_AUTH_TOKEN)) })
        .flatMap { tuple -> Mono.just(tuple) }
        .flatMap { tuple ->
            val response =
                "POST the book( ${tuple.t1.bookName}, ${tuple.t1.author} ) with token: ${tuple.t2}"
            return@flatMap Mono.just(response)
        }

}
