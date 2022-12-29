package com.inditex.challengeinditex.controller

import com.inditex.challengeinditex.model.Shirt
import com.inditex.challengeinditex.service.ShirtService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/shirts")
class ShirtController (
    private val shirtService: ShirtService
) {
    @GetMapping
    fun getShirts(): List<Shirt> = shirtService.getShirts()

    @GetMapping("/sorted/{salesPoints}/{stockPoints}")
    fun sortedShirts(@PathVariable salesPoints: Int, @PathVariable stockPoints: Int): List<Shirt> =
        shirtService.sortedShirts(salesPoints, stockPoints)
}