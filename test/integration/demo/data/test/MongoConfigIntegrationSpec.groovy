package demo.data.test

import grails.test.spock.IntegrationSpec
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.data.mongodb.core.MongoTemplate

class MongoConfigIntegrationSpec extends IntegrationSpec {

    MongoTemplate mongoTemplate
    GrailsApplication grailsApplication

    def setup() {
    }

    def cleanup() {
    }

    void "test Mongo Config"() {
        expect:
        mongoTemplate
        mongoTemplate.getDb().name == grailsApplication.config.mongo.dataSource.database
    }
}
