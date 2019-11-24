package home.sp.balance.entities

import java.util.*
import javax.persistence.Id
import kotlin.collections.ArrayList

class Expense(@Id var commonUuid: UUID?, var items: ArrayList<BalanceRow>?) {
    override fun toString(): String {
        return "Expense(commonUuid=$commonUuid, items=$items)"
    }
}