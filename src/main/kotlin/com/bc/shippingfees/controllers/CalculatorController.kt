package com.bc.shippingfees.controllers

import com.bc.shippingfees.mock.CompaniesMock
import com.bc.shippingfees.mock.FeeRangesMock
import com.bc.shippingfees.mock.ProductsMock
import com.bc.shippingfees.utils.calculateFee
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController {
    //http://localhost:9090/shipping-cost?idProduct=10&distance=1
    @GetMapping("/shipping-cost")
    fun shippiningCosts(@RequestParam(name = "idProduct") idProduct: Long, @RequestParam(name = "distance") distance: Long): List<budgetsOutput> {
        val product = ProductsMock.products.find { product -> product.idProduct == idProduct }
        val budgets = mutableListOf<budgetsOutput>()
        requireNotNull(product)

        CompaniesMock.companies.forEach { company ->
            val fees = FeeRangesMock.feesRanges.find { feesRange -> feesRange.idCompany == company.idCompany && product.weight in feesRange.rangeWeight }
            requireNotNull(fees)
            var cost = calculateFee(fees.fixedFee, fees.kmByKgFee, product, distance)
            budgets.add(budgetsOutput(companyName = company.name, budget = cost))
        }
        return budgets.sortedBy { budget -> budget.budget }
    }

    data class budgetsOutput(
            var companyName: String,
            var budget: Double
    )
}
