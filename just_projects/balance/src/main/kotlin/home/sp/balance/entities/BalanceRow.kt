package home.sp.balance.entities

import java.util.*

class BalanceRow(val uuid: UUID?, val uuid2: UUID?,val date: Date?, val price: Double?, val categoty: String?, val name: String?) {
    override fun toString(): String {
        return "BalanceRow(name=$name, price=$price, categoty=$categoty, date=$date, uuid=$uuid, uuid2=$uuid2)"
    }
}