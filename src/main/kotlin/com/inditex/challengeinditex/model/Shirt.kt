package com.inditex.challengeinditex.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Shirt (
    @Id
    val id: String,
    val name: String,
    val sales: Int,
    val stockS: Int,
    val stockM: Int,
    val stockL: Int,
)