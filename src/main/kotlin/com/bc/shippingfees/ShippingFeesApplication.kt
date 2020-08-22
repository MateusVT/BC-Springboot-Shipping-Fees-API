package com.bc.shippingfees

import Models.Company
import Models.Product
import com.bc.shippingfees.security.CustomWebMvcConfigurer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class ShippingFeesApplication

fun main(args: Array<String>) {
    runApplication<ShippingFeesApplication>(*args)
    corsConfigurer()
}

@Bean
fun corsConfigurer(): WebMvcConfigurer {
    return CustomWebMvcConfigurer()
}
