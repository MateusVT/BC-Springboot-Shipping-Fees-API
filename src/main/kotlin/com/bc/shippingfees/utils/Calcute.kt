package com.bc.shippingfees.utils

import Models.Product

fun calculateFee(fixedFee: Double, kmByKgFee: Double, product: Product, distance: Long): Double {
    return fixedFee + (product.weight * distance * kmByKgFee)
}