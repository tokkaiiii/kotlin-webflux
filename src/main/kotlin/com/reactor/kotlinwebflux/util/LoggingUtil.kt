package com.reactor.kotlinwebflux.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory

val log: Logger = LoggerFactory.getLogger("LoggingUtil")!!


fun info(data: Any) {
    log.info("$data")
}

fun info(message: String, data: Any) {
    log.info("$message: $data")
}

fun doOnNext(data: Any) {
    log.info("# doOnNext(): $data")
}

fun doOnNext(operator: String, data: Any) {
    log.info("# doOnNext() $operator: $data")
}

fun doOnRequest(data: Any) {
    log.info("# doOnRequest() $data")
}

fun onNext(data: Any) {
    log.info("# onNext() $data")
}

fun onNext(data1: Any, data2: Any) {
    log.info("# onNext() $data1 : $data2")
}

fun doOnNext(taskName: String, operator: String, data: Any) {
    log.info("# doOnNext() $taskName $operator: $data")
}

fun onError(error: Throwable) {
    log.error("error happened: ", error)
}

fun onComplete() {
    log.info("# onComplete()")
}

fun onComplete(data: Any) {
    log.info("# onComplete(): $data")
}


