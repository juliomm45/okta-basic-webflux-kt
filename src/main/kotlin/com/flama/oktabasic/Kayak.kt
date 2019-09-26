package com.flama.oktabasic

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Kayak(
        @Id val id: String? = null,
        val owner: String,
        val value: Int,
        val makeModel: String
)