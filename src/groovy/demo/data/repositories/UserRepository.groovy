package demo.data.repositories

import demo.data.domain.User
import org.springframework.data.repository.Repository

/**
 * Created by jitendra on 9/2/16.
 */
interface UserRepository extends Repository<User, Long> {
    User save(User user)
    User findOne(Long id)
}