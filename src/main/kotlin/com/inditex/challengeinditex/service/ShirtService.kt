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

    fun sortedShirts(salesPoints: Int, stockPoints: Int): List<Shirt> {
        val shirts = repository.findAll()
        return shirts.sortedByDescending { it.sales * salesPoints + it.getStock() * stockPoints }
    }
}

private fun Shirt.getStock(): Int {
    return this.stockL + this.stockM + this.stockS
}