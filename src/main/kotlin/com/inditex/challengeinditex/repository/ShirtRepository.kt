package com.inditex.challengeinditex.repository

import com.inditex.challengeinditex.model.Shirt
import org.springframework.data.mongodb.repository.MongoRepository

interface ShirtRepository: MongoRepository <Shirt, String> {

}