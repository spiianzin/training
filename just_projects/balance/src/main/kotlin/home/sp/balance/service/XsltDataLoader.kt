package home.sp.balance.service

import home.sp.balance.entities.Expense
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.File

class XsltDataLoader : DataLoader<File, List<Expense>> {
    override fun load(source: File) {
        val workbook = WorkbookFactory.create(source)
        val sheet = workbook.getSheetAt(0)
        sheet.getRow(2).getCell(14)

        for (i in 2..sheet.lastRowNum) {
            println(sheet.getRow(i).getCell(NAME)?.stringCellValue + " " + sheet.getRow(i).getCell(COST)?.numericCellValue + " "
                    + sheet.getRow(i).getCell(COUNT)?.numericCellValue + " " + sheet.getRow(i).getCell(TOTAL)?.numericCellValue)
        }
    }

    companion object {
        const val SELLER: Int = 13
        const val CATEGORY: Int = 13
        const val NAME: Int = 14
        const val COST: Int = 15
        const val COUNT: Int = 16
        const val TOTAL: Int = 17
    }
}