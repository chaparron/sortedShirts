package com.inditex.challengeinditex.service

import com.inditex.challengeinditex.dataSource.ShirtDataSourceInterface
import com.inditex.challengeinditex.model.Shirt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExtendWith(MockitoExtension::class)
internal class ShirtServiceTest {

    private val dataSource: ShirtDataSourceInterface = mock()
    private val service = ShirtService(dataSource)

    private val shirtList = listOf(
        Shirt("1", "V-NECH BASIC SHIRT", 100, 4 ,9 ,0),
        Shirt("2", "CONTRASTING FABRIC T-SHIRT", 50, 35 ,9 ,9),
        Shirt("3", "RAISED PRINT T-SHIRT", 80, 20 ,2 ,20),
        Shirt("4", "PLEATED T-SHIRT", 3, 25 ,30 ,10),
        Shirt("5", "CONTRASTING LACE T-SHIRT", 650, 0 ,1 ,0),
        Shirt("6", "SLOGAN T-SHIRT", 20, 9 ,2 ,5),
    )

    @Test
    fun `Should call its data source to retrieve Shirts`() {

        whenever(service.getShirts()).thenReturn(shirtList)

        val shirts = service.getShirts()

        verify(dataSource).getShirts()
    }
}