package demo.data.repositories

import demo.data.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * Created by jitendra on 9/2/16.
 */
interface UserRepository extends MongoRepository<User, Long> {
    User findByNameAndAge(String name, Integer age)
    List<User> findAllByAgeGreaterThanEqual(Integer age)
}