package home.sp.balance.entities

import java.util.*
import kotlin.collections.ArrayList

class Expense(var commonUuid: UUID?, var items: ArrayList<BalanceRow>) {
    override fun toString(): String {
        return "Expense(commonUuid=$commonUuid, items=$items)"
    }
}