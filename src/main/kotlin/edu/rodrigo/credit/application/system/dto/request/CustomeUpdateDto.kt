package edu.rodrigo.credit.application.system.dto.request

import edu.rodrigo.credit.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomeUpdateDto(
        @field:NotEmpty(message = "Invalid Imput")
        val firstName: String,

        @field:NotEmpty(message = "Invalid Imput")
        val lastName: String,

        @field:NotNull(message = "Invalid Imput")
        val income: BigDecimal,

        @field:NotEmpty(message = "Invalid Imput")
        val zipCode: String,

        @field:NotEmpty(message = "Invalid Imput")
        val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}

