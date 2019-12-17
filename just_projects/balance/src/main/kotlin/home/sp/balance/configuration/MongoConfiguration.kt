package home.sp.balance.configuration

import com.mongodb.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import java.io.IOException
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;






@Configuration
class MongoConfiguration() {

//    @Bean
//    fun mongo(): MongoClient {
//        return MongoClient("localhost")
//    }

//    @Bean
//    @Throws(Exception::class)
//    fun mongoTemplate(): MongoTemplate {
//        return MongoTemplate(mongo(), "test")
//    }

    private val MONGO_DB_URL = "localhost"
    private val MONGO_DB_NAME = "embeded_db"
    @Bean
    @Throws(IOException::class)
    fun mongoTemplate(): MongoTemplate {
        val mongo = EmbeddedMongoFactoryBean()
        mongo.setBindIp(MONGO_DB_URL)
        val mongoClient: MongoClient = mongo.getObject()!!
        return MongoTemplate(mongoClient, MONGO_DB_NAME)
    }
}