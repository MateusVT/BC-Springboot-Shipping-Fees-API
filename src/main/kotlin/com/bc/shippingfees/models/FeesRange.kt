package Models

import javafx.scene.text.FontWeight

data class FeesRange(
        var idCompany: Long,
        var rangeWeight: ClosedFloatingPointRange<Double>,
        var fixedFee: Double,
        var kmByKgFee: Double
)

