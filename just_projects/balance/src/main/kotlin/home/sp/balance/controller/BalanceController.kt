package home.sp.balance.controller

import home.sp.balance.entities.BalanceRow
import home.sp.balance.service.BalanceService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1")
class BalanceController(val balanceService: BalanceService) {
    @GetMapping("row/{uuid}")
    @ResponseBody
    fun getByUuid(@PathVariable uuid: String): BalanceRow {
        return balanceService.findByUuid(uuid)
    }

    @GetMapping("rows")
    @ResponseBody
    fun getByCategory(@RequestParam category: String): List<BalanceRow> {
        return balanceService.findByCategory(category)
    }
}