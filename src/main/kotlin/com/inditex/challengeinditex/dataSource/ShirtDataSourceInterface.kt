package com.inditex.challengeinditex.dataSource

import com.inditex.challengeinditex.model.Shirt

interface ShirtDataSourceInterface {
    fun retrieveShirts(): List<Shirt>
}