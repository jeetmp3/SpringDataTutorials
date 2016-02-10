package demo.data.test

import demo.data.domain.User
import demo.data.repositories.UserRepository
import grails.test.spock.IntegrationSpec
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

class PagingAndSortingRepositoryIntegrationSpec extends IntegrationSpec {

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

    void "test Sort test"() {
        when:
        List<User> userList = userRepository.findAll(new Sort(new Sort.Order(Sort.Direction.DESC, "id")))

        then:
        userList.size() == 10
        userList.first().id == 10L
        userList.first().name == "User10"
    }

    void "test Pageable"() {
        when:
        Page<User> userList = userRepository.findAll(new PageRequest(1, 3))

        then:
        userList.totalElements == 10
        userList.totalPages == 4
        userList.size == 3
        userList.first().id == 4L
        userList.first().name == "User4"
    }
}
