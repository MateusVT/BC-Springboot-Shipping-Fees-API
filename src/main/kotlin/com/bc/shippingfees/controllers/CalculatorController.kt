package com.bc.shippingfees.controllers

import Models.Product
import com.bc.shippingfees.mocks.CompaniesMock
import com.bc.shippingfees.mocks.FeeRangesMock
import com.bc.shippingfees.mocks.ProductsMock
import com.bc.shippingfees.utils.calculateFee
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shipping-costs")
class CalculatorController {

    @GetMapping("/by-registered-product")
    fun shippingCostsByRegisteredProduct(@RequestParam(name = "idProduct") idProduct: Long, @RequestParam(name = "distance") distance: Long): List<BudgetsOutput> {
        val product = ProductsMock.products.find { product -> product.idProduct == idProduct }
        requireNotNull(product)

        val budgets = mutableListOf<BudgetsOutput>()

        CompaniesMock.companies.forEach { company ->
            val fees = FeeRangesMock.feesRanges.find { feesRange ->
                feesRange.idCompany == company.idCompany
                        && product.weight.toDouble() in feesRange.rangeWeight
            }
            requireNotNull(fees)

            val cost = calculateFee(fees.fixedFee, fees.kmByKgFee, product, distance)
            budgets.add(BudgetsOutput(companyName = company.name, budget = cost))
        }

        return budgets.sortedBy { budget -> budget.budget }
    }

    @PostMapping("/by-unregistered-product")
    fun shippingCostsByUnregisteredProduct(@RequestBody inputData: ProductsInput): List<BudgetsOutput> {
        val budgets = mutableListOf<BudgetsOutput>()

        CompaniesMock.companies.forEach { company ->
            val fees = FeeRangesMock.feesRanges.find { feesRange -> feesRange.idCompany == company.idCompany && inputData.product.weight.toDouble() in feesRange.rangeWeight }
            requireNotNull(fees)
            val cost = calculateFee(fees.fixedFee, fees.kmByKgFee, inputData.product, inputData.distance)
            budgets.add(BudgetsOutput(companyName = company.name, budget = cost))
        }

        return budgets.sortedBy { budget -> budget.budget }
    }

    @PostMapping("/by-unregistered-products")
    fun shippingCostsByUnregisteredProducts(@RequestBody inputData: List<ProductsInput>): List<BudgetsOutputByProduct> {
        val outPutBudgets = mutableListOf<BudgetsOutputByProduct>()

        inputData.forEach { input ->
            val budgetsList = mutableListOf<BudgetsOutput>()

            CompaniesMock.companies.forEach { company ->

                val fees = FeeRangesMock.feesRanges.find { feesRange ->
                    feesRange.idCompany == company.idCompany
                            && input.product.weight.toDouble() in feesRange.rangeWeight
                }
                requireNotNull(fees)

                val cost = calculateFee(fees.fixedFee, fees.kmByKgFee, input.product, input.distance)

                budgetsList.add(BudgetsOutput(companyName = company.name, budget = cost))
            }
            outPutBudgets.add(BudgetsOutputByProduct(product = input.product, budgets = budgetsList.sortedBy { budget -> budget.budget }))
        }

        return outPutBudgets
    }


    data class BudgetsOutputByProduct(
            val product: Product,
            val budgets: List<BudgetsOutput>
    )

    data class BudgetsOutput(
            val companyName: String,
            val budget: Double
    )

    data class ProductsInput(
            val product: Product,
            val distance: Long
    )

}
