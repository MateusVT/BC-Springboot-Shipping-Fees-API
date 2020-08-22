package com.bc.shippingfees.security


import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class CustomWebMvcConfigurer : WebMvcConfigurer {
    public override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/products").allowedOrigins("*")
    }
}
