package home.sp.balance

import home.sp.balance.configuration.MongoConfiguration
import home.sp.balance.repository.BalanceRowRepository
import home.sp.balance.repository.ExpenseRepository
import org.elasticsearch.action.index.IndexRequest
import org.elasticsearch.action.support.WriteRequest
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.util.*
import java.util.Collections.singletonMap


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
    @Autowired
    lateinit var highLevelClient: RestHighLevelClient

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        println("Hello!")
        val request: IndexRequest = IndexRequest("spring-data", "elasticsearch", UUID.randomUUID().toString())
                .source(singletonMap("feature", "high-level-rest-client"))
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        highLevelClient.index(request, RequestOptions.DEFAULT)

//        balanceRowRepository.saveAll(XsltDataLoader().load(File(args[0])));
//        val list = balanceRowRepository.findAll()
//        val balanceRow = balanceRowRepository.findById(UUID.fromString("7c4410b9-335c-4693-9903-c39cc64aa8e9"))
//        println(balanceRow.orElse(null))
    }
}
