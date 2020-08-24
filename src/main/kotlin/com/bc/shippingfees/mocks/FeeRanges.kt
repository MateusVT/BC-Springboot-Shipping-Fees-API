package com.bc.shippingfees.mocks

import Models.FeesRange

object FeeRangesMock {
    val feesRanges = listOf(
            FeesRange(1, (0.0..Double.MAX_VALUE), 10.0, 0.05),
            FeesRange(2, (0.0..Double.MAX_VALUE), 4.3, 0.12),
            FeesRange(3, (0.0..5.0), 2.10, 1.10),
            FeesRange(3, (5.0..Double.MAX_VALUE), 10.0, 0.01)
    )
}


