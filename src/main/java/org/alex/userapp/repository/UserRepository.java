package org.alex.userapp.repository;

import org.alex.userapp.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


/**
 * @ClassName: UserRepository
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{email:?0}")
    Optional<User> getUserByEmail(String email);
}
