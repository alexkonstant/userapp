package org.alex.userapp.service.serviceImpl;

import org.alex.userapp.adapter.UserDTOToDomainAdapter;
import org.alex.userapp.domain.User;
import org.alex.userapp.dto.UserDTO;
import org.alex.userapp.repository.UserRepository;
import org.alex.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return List of existing users from DB
     */
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param user DTO model of user that is being added to DB
     * @return Message with status of DB operation
     */
    @Override
    public String addUser(UserDTO user) {
        User dbUser = UserDTOToDomainAdapter.adapt(user);
        Optional<User> existingUser = userRepository.getUserByEmail(user.getEmail());
        if (existingUser.isEmpty()) {
            userRepository.insert(dbUser);
            return "OK";
        } else {
            return "User with this email already exists!";
        }
    }

    /**
     * @param user User object that is being updated
     * @return Message with status of DB operation
     */
    @Override
    public String updateUser(User user) {
        Optional<User> userFromDB = userRepository.findById(user.getId());
        if (userFromDB.isPresent()) {
            User updatedUser = userFromDB.get();
            updatedUser = updatedUser.clone(user);
            userRepository.save(updatedUser);
            return "OK";
        } else {
            return "No user with this email found!";
        }
    }

    /**
     * @param user User object that is being deleted
     */
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
