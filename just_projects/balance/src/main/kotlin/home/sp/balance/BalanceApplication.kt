package home.sp.balance

import home.sp.balance.configuration.MongoConfiguration
import home.sp.balance.service.XsltDataLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component
import java.io.File

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
    lateinit var mongoTemplate: MongoTemplate

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        println("Hello!")
        XsltDataLoader().load(File(args[0]))
    }
}
