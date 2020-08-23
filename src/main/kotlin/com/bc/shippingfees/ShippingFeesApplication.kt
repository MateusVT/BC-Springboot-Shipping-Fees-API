package com.bc.shippingfees

import Models.Product
import com.bc.shippingfees.mocks.ProductsMock
import net.minidev.json.JSONObject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
class ShippingFeesApplication

fun main(args: Array<String>) {
    runApplication<ShippingFeesApplication>(*args)
}

