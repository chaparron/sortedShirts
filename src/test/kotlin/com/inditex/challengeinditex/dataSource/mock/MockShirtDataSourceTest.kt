package com.inditex.challengeinditex.dataSource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockShirtDataSourceTest {

    private val mockDataSource = MockShirtDataSource()

    @Test
    fun `should provide a collection of Shirts`() {
        val shirts = mockDataSource.retrieveShirts()
        assertThat(shirts).isNotEmpty
    }

    @Test
    fun `should provide valid data`() {
        val shirts = mockDataSource.retrieveShirts()
        assertThat(shirts).allMatch {
            it.id.isNotBlank()
                && it.name.isNotBlank()
                && it.sales >= 0
                && it.stockS >= 0
                && it.stockM >= 0
                && it.stockL >= 0
        }
    }
}