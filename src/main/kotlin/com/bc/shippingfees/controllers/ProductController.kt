package com.bc.shippingfees.controllers


import Models.Product
import com.bc.shippingfees.mock.ProductsMock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return ProductsMock.products
    }

}
