package com.bc.shippingfees.controllers

import com.bc.shippingfees.mock.CompaniesMock
import com.bc.shippingfees.mock.ProductsMock
import com.bc.shippingfees.utils.calculateFee
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {


    @GetMapping("/shipping-cost/{idCompany}/{idProduct}/{distance}")
    fun shippiningCost(@PathVariable idCompany: Long, @PathVariable idProduct: Long, @PathVariable distance: Long): outPutData {
        val company = CompaniesMock.companies.find { company -> company.idCompany == idCompany }
        val product = ProductsMock.products.find { product -> product.idProduct == idProduct }
        requireNotNull(company)
        requireNotNull(product)
        var cost = calculateFee(company, product, distance)
        val outPut = outPutData(cost = cost)

        return outPut
    }

    data class outPutData(
            var cost: Double
    )


}
