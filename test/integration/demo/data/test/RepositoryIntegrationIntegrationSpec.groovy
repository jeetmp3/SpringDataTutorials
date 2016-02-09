package demo.data.test

import demo.data.domain.User
import demo.data.repositories.UserRepository
import grails.test.spock.IntegrationSpec

class RepositoryIntegrationIntegrationSpec extends IntegrationSpec {

    UserRepository userRepository

    def setup() {
    }

    def cleanup() {
    }

    def "repository injection test"() {
        expect:
            userRepository
    }

    void "test Save and Find"() {
        setup:
            User user = new User(id: 1L, name: 'SpringData', age: 25, dateCreated: new Date())

        when:
            User savedUser = userRepository.save(user)
        and:
            User fetchedUser = userRepository.findOne(1L)
        then:
            user.id == savedUser.id && user.id == fetchedUser.id
            user.name == savedUser.name && user.name == fetchedUser.name
    }
}
