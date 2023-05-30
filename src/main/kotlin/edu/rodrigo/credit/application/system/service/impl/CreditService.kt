package edu.rodrigo.credit.application.system.service.impl

import edu.rodrigo.credit.application.system.entity.Credit
import edu.rodrigo.credit.application.system.exception.BusinessException
import edu.rodrigo.credit.application.system.repository.CreditRepository
import edu.rodrigo.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
        private val creditRepository: CreditRepository,
        private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
            this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit = (this.creditRepository.findByCreditCode(creditCode)
                ?: throw BusinessException("CreditCode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw IllegalAccessException("Contact admin")
    }
}