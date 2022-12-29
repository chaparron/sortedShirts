package com.inditex.challengeinditex.dataSource.mock

import com.inditex.challengeinditex.dataSource.ShirtDataSourceInterface
import com.inditex.challengeinditex.model.Shirt
import org.springframework.stereotype.Repository

@Repository
class MockShirtDataSource: ShirtDataSourceInterface {

    val shirts = listOf(
        Shirt("1", "V-NECH BASIC SHIRT", 100, 4 ,9 ,0),
        Shirt("2", "CONTRASTING FABRIC T-SHIRT", 50, 35 ,9 ,9),
        Shirt("3", "RAISED PRINT T-SHIRT", 80, 20 ,2 ,20),
        Shirt("4", "PLEATED T-SHIRT", 3, 25 ,30 ,10),
        Shirt("5", "CONTRASTING LACE T-SHIRT", 650, 0 ,1 ,0),
        Shirt("6", "SLOGAN T-SHIRT", 20, 9 ,2 ,5),
    )
    override fun retrieveShirts(): List<Shirt> {
        return shirts
    }
}