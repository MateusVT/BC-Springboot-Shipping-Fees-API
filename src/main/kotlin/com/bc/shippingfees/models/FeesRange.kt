package Models

import javafx.scene.text.FontWeight

data class FeesRange(
        val idCompany: Long,
        val rangeWeight: ClosedFloatingPointRange<Double>,
        val fixedFee: Double,
        val kmByKgFee: Double
)

