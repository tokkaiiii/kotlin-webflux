package com.reactor.kotlinwebflux.day02.mono

import com.jayway.jsonpath.JsonPath
import com.reactor.kotlinwebflux.util.info
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.*
import org.springframework.http.MediaType.*
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import reactor.core.publisher.Mono
import java.util.Collections.*

fun main() {
    val worldTimeUrl = UriComponentsBuilder.newInstance().scheme("http")
        .host("worldtimeapi.org")
        .port(80)
        .path("/api/timezone/Asia/Seoul")
        .encode()
        .build().toUri()

    val restTemplate = RestTemplate()
    val headers = HttpHeaders()
    headers.accept = singletonList(APPLICATION_JSON)

    Mono.just(
        restTemplate.exchange(worldTimeUrl, GET, HttpEntity<String>(headers), String::class.java)
    ).map { response ->
        JsonPath.parse(response.body).read<Any>("$.datetime")
    }
        .subscribe(
            { info("# emitted data: $it")},{
                    ex -> println(ex.message)
            },{ info("# emitted onComplete signal") }
        )
}