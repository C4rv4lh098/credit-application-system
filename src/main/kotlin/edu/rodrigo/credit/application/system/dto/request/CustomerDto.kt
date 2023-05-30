package edu.rodrigo.credit.application.system.dto.request

import edu.rodrigo.credit.application.system.entity.Address
import edu.rodrigo.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

class CustomerDto(
        @field:NotEmpty(message = "Invalid Imput")
        val firstName: String,

        @field:NotEmpty(message = "Invalid Imput")
        val lastName: String,

        @field:NotEmpty(message = "Invalid Imput")
        @field:CPF(message = "Invalid CPF")
        val cpf: String,

        @field:NotNull(message = "Invalid Imput")
        val income: BigDecimal,

        @field:Email(message = "Invalid Email")
        @field:NotEmpty(message = "Invalid Imput")
        val email: String,

        @field:NotEmpty(message = "Invalid Imput")
        val passowrd: String,

        @field:NotEmpty(message = "Invalid Imput")
        val zipCode: String,

        @field:NotEmpty(message = "Invalid Imput")
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
