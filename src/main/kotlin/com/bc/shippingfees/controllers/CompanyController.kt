package com.bc.shippingfees.controllers


import Models.Company
import com.bc.shippingfees.mocks.CompaniesMock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController {
    @GetMapping("/companies")
    fun getCompanies(): List<Company> {
        return CompaniesMock.companies
    }

    @GetMapping("/company")
    fun getCompanyById(@RequestParam(name = "idCompany") idCompany: Long): Company? {
        return CompaniesMock.companies.find { company -> company.idCompany == idCompany }
    }
}
