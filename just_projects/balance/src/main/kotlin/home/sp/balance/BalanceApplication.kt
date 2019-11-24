package home.sp.balance

import home.sp.balance.configuration.MongoConfiguration
import home.sp.balance.entities.BalanceRow
import home.sp.balance.repository.BalanceRowRepository
import home.sp.balance.repository.ExpenseRepository
import home.sp.balance.service.XsltDataLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.io.File
import java.util.*

@SpringBootApplication(
        exclude = [DataSourceAutoConfiguration::class],
        scanBasePackageClasses = [MongoConfiguration::class, BalanceApplication::class])
class BalanceApplication

fun main(args: Array<String>) {
    runApplication<BalanceApplication>(*args)
}

@Component
class CommandLineAppStartupRunner : CommandLineRunner {

    @Autowired
    lateinit var expenseRepository: ExpenseRepository
    @Autowired
    lateinit var balanceRowRepository: BalanceRowRepository

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        println("Hello!")
//        balanceRowRepository.saveAll(XsltDataLoader().load(File(args[0])));
//        val list = balanceRowRepository.findAll()
//        val balanceRow = balanceRowRepository.findById(UUID.fromString("7c4410b9-335c-4693-9903-c39cc64aa8e9"))
//        println(balanceRow.orElse(null))
    }
}
