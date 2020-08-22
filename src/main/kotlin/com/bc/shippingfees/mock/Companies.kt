package com.bc.shippingfees.mock

import Models.Company

object CompaniesMock {
    var companies = listOf(
            Company(0, "BoaDex", 10.0, 0.05),
            Company(1, "BoaLog", 4.3, 0.12),
            Company(2, "Transboa", 2.1, 1.10),
            Company(3, "Transboa", 10.0, 0.01)
    )
}

