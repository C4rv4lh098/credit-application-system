package edu.rodrigo.credit.application.system.dto

import edu.rodrigo.credit.application.system.entity.Credit
import edu.rodrigo.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        val creditValue: BigDecimal,
        val dayFirstOfInstallments: LocalDate,
        val numberOfInstallments: Int,
        val customerId: Long
) {
    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFirstIntallments = this.dayFirstOfInstallments,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )
}
