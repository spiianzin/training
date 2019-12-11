package home.sp.balance.repository

import home.sp.balance.entities.Expense
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ExpenseRepository : MongoRepository<Expense, UUID> {
}