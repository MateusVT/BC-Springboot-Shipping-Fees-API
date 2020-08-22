package com.bc.shippingfees.utils

import Models.Company
import Models.Product


fun calculateFee(company: Company, product: Product, distance: Long): Double {
    var cost = company.fixedFee + (product.weight * distance * company.kmByKgFee)
    return cost
}