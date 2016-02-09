package demo.data.config

import com.mongodb.Mongo
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


/**
 * Created by jitendra on 9/2/16.
 */
@Configuration
@EnableMongoRepositories(basePackages = "demo.data.repositories")
class SpringDataMongodbConfig extends AbstractMongoConfiguration {

    GrailsApplication grailsApplication

    @Override
    protected String getDatabaseName() {
        return grailsApplication.config.mongo.dataSource.database
    }

    @Override
    Mongo mongo() throws Exception {
        ConfigObject object = grailsApplication.config.mongo.dataSource
        return new Mongo(object.hostName as String, object.port as Integer)
    }
}
