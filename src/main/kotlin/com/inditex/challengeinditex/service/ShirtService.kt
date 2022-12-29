package com.inditex.challengeinditex.service

import com.inditex.challengeinditex.dataSource.mock.MockShirtDataSource
import com.inditex.challengeinditex.model.Shirt
import org.springframework.stereotype.Service

@Service
class ShirtService (private val dataSource: MockShirtDataSource){

    fun getShirts(): List<Shirt> = dataSource.retrieveShirts()

    fun sortedShirts(salesPoints: Int, stockPoints: Int): List<Shirt> {
        val shirts = dataSource.retrieveShirts()
        return shirts.sortedByDescending { it.sales * salesPoints + it.getStock() * stockPoints}
    }

}

private fun Shirt.getStock(): Int {
    return this.stockL + this.stockM + this.stockS
}