package com.bc.shippingfees.controllers


import Models.Product
import com.bc.shippingfees.mocks.ProductsMock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {

    @GetMapping("/products")
    fun getProducts(): List<Product> {
        return ProductsMock.products
    }

    @GetMapping("/product")
    fun getProductsById(@RequestParam(name = "idProduct") idProduct: Long): Product? {
        return ProductsMock.products.find { product -> product.idProduct == idProduct }
    }

}
