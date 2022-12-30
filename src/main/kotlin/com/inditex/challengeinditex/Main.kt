package com.inditex.challengeinditex

import com.inditex.challengeinditex.model.Shirt
import com.inditex.challengeinditex.repository.ShirtRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@SpringBootApplication
class ChallengeInditexApplication

fun main(args: Array<String>) {
    runApplication<ChallengeInditexApplication>(*args)
}

@Configuration
class KotlinSerializationConfiguration {
    @Bean
    fun json() = Json
}

@Configuration
class InitDataConfiguration {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Autowired
    private lateinit var repository: ShirtRepository


    @Bean
    fun initData() {
        logger.info("Clearing previous data")
        repository.deleteAll()
        logger.info("About to create some data")

        initShirtsData()
        logger.info("Data saved")
    }

    private fun initShirtsData() {
        val shirts = listOf(
            Shirt("1", "V-NECH BASIC SHIRT", 100, 4, 9, 0),
            Shirt("2", "CONTRASTING FABRIC T-SHIRT", 50, 35, 9, 9),
            Shirt("3", "RAISED PRINT T-SHIRT", 80, 20, 2, 20),
            Shirt("4", "PLEATED T-SHIRT", 3, 25, 30, 10),
            Shirt("5", "CONTRASTING LACE T-SHIRT", 650, 0, 1, 0),
            Shirt("6", "SLOGAN T-SHIRT", 20, 9, 2, 5),
        )
        for (shirt in shirts) {
            repository.save(shirt)
        }
    }
}