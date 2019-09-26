package com.flama.oktabasic

import reactor.core.publisher.Flux
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import reactor.core.publisher.Mono
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller


@Controller
@RequestMapping(path = ["/kayaks"])
class KayakController(private val kayakRepository: KayakRepository) {

    val allKayaks: Flux<Kayak>
        @GetMapping
        @ResponseBody
        get() = kayakRepository.findAll()

    @PostMapping
    @ResponseBody
    fun addKayak(@RequestBody kayak: Kayak): Mono<Kayak> {
        return kayakRepository.save(kayak)
    }
}