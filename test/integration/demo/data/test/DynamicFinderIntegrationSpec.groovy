package demo.data.test

import demo.data.domain.User
import demo.data.repositories.UserRepository
import grails.test.spock.IntegrationSpec
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

class DynamicFinderIntegrationSpec extends IntegrationSpec {

    UserRepository userRepository

    def setup() {
        10.times {
            Integer id = it + 1
            userRepository.save(
                    new User(id: id, name: "User${id}", age: 20 + id, dateCreated: new Date())
            )
        }
    }

    def cleanup() {
        10.times {
            Integer id = it + 1
            userRepository.delete(id)
        }
    }

    void "test findByNameAndAge"() {
        when:
        User user = userRepository.findByNameAndAge('User1', 21)

        then:
        user
        user.name == 'User1'
        user.age == 21
    }

    void "test findAllByAgeGreaterThanEqual"() {
        when:
        List<User> userList = userRepository.findAllByAgeGreaterThanEqual(25)

        then:
        userList
        userList.size() == 6
        userList.first().id == 5L
        userList.first().age == 25
        userList.first().name == "User5"
    }
}
