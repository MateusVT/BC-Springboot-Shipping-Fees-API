package com.bc.shippingfees.mock

import Models.FeesRange
import jdk.nashorn.internal.objects.Global.Infinity

object FeeRangesMock {
    var feesRanges = listOf(
            FeesRange(0, (0.0..Infinity), 10.0, 0.05),
            FeesRange(1, (0.0..Infinity), 4.3, 0.12),
            FeesRange(2, (0.0..5.0), 2.10, 1.10),
            FeesRange(2, (5.0..Infinity), 10.0, 0.01)
    )
}


