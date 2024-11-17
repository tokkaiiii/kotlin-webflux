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

    fun doOnNext(data: Any){
        log.info(" $data")
    }

    fun onError(error: Throwable){
        log.error("error happened: ",error)
    }

