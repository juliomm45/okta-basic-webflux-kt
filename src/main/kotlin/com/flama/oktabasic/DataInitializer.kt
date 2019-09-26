package com.flama.oktabasic

import org.reactivestreams.Publisher
import reactor.core.publisher.Flux
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean


@Bean
fun init(repository: KayakRepository): ApplicationRunner {

    val data = arrayOf(arrayOf("sea", "Andrew", 300.12, "NDK"), arrayOf("creek", "Andrew", 100.75, "Piranha"), arrayOf("loaner", "Andrew", 75, "Necky"))

    return ApplicationRunner {
        repository
                .deleteAll()
                .thenMany(
                        Flux
                                .just(*data)
                                .map { array -> Kayak(array[0] as String, array[1] as String, (array[2] as Number).toInt(), array[3] as String) }
                                .flatMap { repository.save(it) }
                )
                .thenMany(repository.findAll())
                .subscribe { kayak -> println("saving $kayak") }
    }
}
