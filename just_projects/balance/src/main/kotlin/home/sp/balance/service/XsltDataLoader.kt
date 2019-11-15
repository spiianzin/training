package home.sp.balance.service

import home.sp.balance.entities.BalanceRow
import home.sp.balance.entities.Expense
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File
import java.time.LocalDateTime
import java.util.*
import java.util.function.Function

class XsltDataLoader : DataLoader<File, List<Expense>> {
    override fun load(source: File) {
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

        for (i in 2..sheet.lastRowNum) {
            println(toBalanceRow.apply(sheet.getRow(i)))
        }
    }

    companion object {
        const val UUID1: Int = 1
        const val UUID2: Int = 2
        const val DATE: Int = 3
        const val SELLER: Int = 13
        const val CATEGORY: Int = 13
        const val NAME: Int = 14
        const val COST: Int = 15
        const val COUNT: Int = 16
        const val TOTAL: Int = 17
    }
}