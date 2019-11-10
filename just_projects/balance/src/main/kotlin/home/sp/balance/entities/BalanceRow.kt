package home.sp.balance.entities

import java.time.LocalDateTime

class BalanceRow(val date: LocalDateTime, val count: Double, val type: ExpensiveType, val comment: String) {
}