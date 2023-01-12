package com.inditex.challengeinditex.service

import com.inditex.challengeinditex.dataSource.mock.MockShirtDataSource
import com.inditex.challengeinditex.model.Shirt
import com.inditex.challengeinditex.repository.ShirtRepository
import org.springframework.stereotype.Service

@Service
class ShirtService(
    private val repository: ShirtRepository
) {
    fun getShirts(): List<Shirt> = repository.findAll()

    fun saveShirt(shirtName: String) = repository.save(shirtName.toShirt())

    fun deleteShirt(id: String) = repository.deleteById(id)

    fun sortedShirts(salesPoints: Int, stockPoints: Int): List<Shirt> {
        val shirts = repository.findAll()
        return shirts.sortedByDescending { it.sales * salesPoints + it.getStock() * stockPoints }
    }
}

private fun String.toShirt(): Shirt = Shirt(
    id = (7..10000).random().toString(),
    name = this,
    sales = (0..1000).random(),
    stockS = (0..100).random(),
    stockM = (0..100).random(),
    stockL = (0..100).random(),
)
private fun Shirt.getStock(): Int {
    return this.stockL + this.stockM + this.stockS
}