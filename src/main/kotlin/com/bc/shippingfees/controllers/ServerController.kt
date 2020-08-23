package com.bc.shippingfees.controllers

import net.minidev.json.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ServerController {
    @GetMapping("/server-status")
    fun server(): JSONObject {
        val server = JSONObject()
        server["name"] = "Shipping Fees Service"
        server["version"] = "prod@1.0.0"
        return server
    }
}