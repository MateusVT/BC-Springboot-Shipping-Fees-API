package Models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class Product(
        // The nullable option on this Key is only tolerable because this class it not real data-based mapped, therefore
        // I choose this representation in order to avoid 'boierplate' the product class declaration for unregistered products.
        val idProduct: Long?,
        val description: String,
        val weight: Long
)

