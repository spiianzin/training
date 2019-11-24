package home.sp.balance.entities

import org.springframework.data.annotation.Id
import java.util.*

class BalanceRow(val uuid: UUID?, @Id val uuid2: UUID?, val date: Date?, val prise: Double?, val category: String?, val name: String?) {
    override fun toString(): String {
        return "BalanceRow(name=$name, price=$prise, categoty=$category, date=$date, uuid=$uuid, uuid2=$uuid2)"
    }
}