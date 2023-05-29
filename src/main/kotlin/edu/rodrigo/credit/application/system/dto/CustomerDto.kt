package edu.rodrigo.credit.application.system.dto

import edu.rodrigo.credit.application.system.entity.Address
import edu.rodrigo.credit.application.system.entity.Customer
import java.math.BigDecimal

class CustomerDto(
        val firstName: String,
        val lastName: String,
        val cpf: String,
        val income: BigDecimal,
        val email: String,
        val passowrd: String,
        val zipCode: String,
        val street: String

) {
    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password = this.passowrd,
            address = Address(
                    zipCode = this.zipCode,
                    street = this.street
            )
    )
}
