package com.inditex.challengeinditex.controller

import com.inditex.challengeinditex.model.Shirt
import com.inditex.challengeinditex.service.ShirtService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/shirts")
class ShirtController (
    private val service: ShirtService
) {
    @GetMapping
    fun getShirts(): List<Shirt> = service.getShirts()

    @GetMapping("/sorted/{salesPoints}/{stockPoints}")
    fun sortedShirts(@PathVariable salesPoints: Int, @PathVariable stockPoints: Int): List<Shirt> =
        service.sortedShirts(salesPoints, stockPoints)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addShirt(@RequestBody shirtName: String): Shirt = service.saveShirt(shirtName)

    @DeleteMapping("/delete/{shirtId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@PathVariable shirtId: String): Unit = service.deleteShirt(shirtId)
}