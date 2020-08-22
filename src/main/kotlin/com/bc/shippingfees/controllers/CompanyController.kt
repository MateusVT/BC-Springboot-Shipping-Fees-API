package com.bc.shippingfees.controllers


import Models.Company
import com.bc.shippingfees.mock.CompaniesMock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController {
    @GetMapping("/companies")
    fun getProducts(): List<Company> {
        return CompaniesMock.companies
    }
}
