package home.sp.balance.repository

import home.sp.balance.entities.BalanceRow
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface BalanceRowRepository : MongoRepository<BalanceRow, UUID> {

    fun findByCategory(category: String): List<BalanceRow>
}