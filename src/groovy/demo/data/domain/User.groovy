package demo.data.domain

import org.springframework.data.annotation.Id

/**
 * Created by jitendra on 9/2/16.
 */
class User {

    @Id
    Long id
    String name
    Integer age
    Date dateCreated
}
