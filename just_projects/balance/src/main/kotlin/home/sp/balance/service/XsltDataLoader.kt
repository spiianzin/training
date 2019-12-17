package home.sp.balance.service

import home.sp.balance.entities.BalanceRow
import home.sp.balance.entities.Expense
import home.sp.balance.entities.RowType
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.util.*
import java.util.function.Function

class XsltDataLoader : DataLoader<File, List<BalanceRow>> {
    override fun load(source: File) : List<BalanceRow> {
        val workbook = WorkbookFactory.create(source)
        val sheet = workbook.getSheetAt(0)
        sheet.getRow(2).getCell(14)

        val toBalanceRow : Function<Row, BalanceRow> = Function {
            BalanceRow(
                    UUID.fromString(it.getCell(UUID1).stringCellValue),
                    UUID.fromString(it.getCell(UUID2).stringCellValue),
                    it.getCell(DATE)?.dateCellValue,
                    it.getCell(COST)?.numericCellValue,
                    it.getCell(CATEGORY)?.stringCellValue,
                    it.getCell(NAME)?.stringCellValue
            )
        }

        val list: ArrayList<BalanceRow> = ArrayList()
        var expense = Expense(null, ArrayList())
        for (i in 2..sheet.lastRowNum) {
            if (RowType.EXPENDITURE.name.equals(sheet.getRow(i).getCell(TYPE).stringCellValue)) {
                val balanceRow = toBalanceRow.apply(sheet.getRow(i))
                list.add(balanceRow)
                if (expense.commonUuid == null) {
                    expense.commonUuid = balanceRow.uuid
                    expense.items?.add(balanceRow)
                } else if (expense.commonUuid == balanceRow.uuid) {
                    expense.items?.add(balanceRow)
                } else {
//                    list.add(expense)
                    expense = Expense(balanceRow.uuid, ArrayList())
                    expense.items?.add(balanceRow)
                }
            }
        }

//        println("count: " + list.size)
//        list.forEach { println(it) }
        return list
    }

    companion object {
        const val TYPE: Int = 0
        const val UUID1: Int = 1
        const val UUID2: Int = 2
        const val DATE: Int = 3
        const val CATEGORY: Int = 13
        const val NAME: Int = 14
        const val COST: Int = 15
        const val COUNT: Int = 16
        const val TOTAL: Int = 17
    }
}