package home.sp.balance

import home.sp.balance.configuration.MongoConfiguration
import home.sp.balance.entities.BalanceRow
import home.sp.balance.entities.FoodExpensiveType
import home.sp.balance.service.DataLoader
import home.sp.balance.service.XsltDataLoader
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import java.io.File
import java.time.LocalDateTime

@SpringBootApplication(
        exclude = [DataSourceAutoConfiguration::class],
        scanBasePackageClasses = [MongoConfiguration::class])
class BalanceApplication

fun main(args: Array<String>) {
    val context = runApplication<BalanceApplication>(*args)
    val mongoTemplate = context.getBean(MongoTemplate::class.java)

    println("Hello!")
    val balanceRow = BalanceRow(LocalDateTime.now(), 10.0, FoodExpensiveType(), "Just a comment")
    mongoTemplate.insert(balanceRow)

    val query = Query()
    query.addCriteria(Criteria.where("comment").`is`("Just a comment"))
    val obj = mongoTemplate.find(query, BalanceRow::class.java)

    println(obj)

    XsltDataLoader().load(File("C:\\Users\\Sergei_Piianzin\\Downloads\\finpix20191111_153724.xlsx"))
}
