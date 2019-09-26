package com.flama.oktabasic

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface KayakRepository : ReactiveMongoRepository<Kayak, Long>