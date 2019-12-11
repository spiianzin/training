package home.sp.balance.service

import home.sp.balance.entities.BalanceRow
import home.sp.balance.repository.BalanceRowRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BalanceService(val balanceRowRepository: BalanceRowRepository) {
    fun findByUuid(uuid: String): BalanceRow {
        val id = UUID.fromString(uuid)
        return balanceRowRepository.findById(id)
                .orElse(BalanceRow(null, null, null, null, null, null))
    }

    fun findByCategory(category: String): List<BalanceRow> {
        return balanceRowRepository.findByCategory(category)
    }

}
