package edu.rodrigo.credit.application.system.dto.request

import edu.rodrigo.credit.application.system.entity.Credit
import edu.rodrigo.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        @field:NotNull(message = "Invalid Imput")
        val creditValue: BigDecimal,

        @field:Future
        val dayFirstOfInstallments: LocalDate,

        @field:Min(value = 1)
        @field:Max(value = 48)
        val numberOfInstallments: Int,

        @field:NotNull(message = "Invalid Imput")
        val customerId: Long
) {
    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFirstIntallments = this.dayFirstOfInstallments,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )
}