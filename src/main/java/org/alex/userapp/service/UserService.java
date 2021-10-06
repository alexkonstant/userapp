package org.alex.userapp.service;

import org.alex.userapp.domain.User;
import org.alex.userapp.dto.UserDTO;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */
public interface UserService {
    List<User> getAllUsers();
    String addUser(UserDTO user);
    String updateUser(User user);
    void deleteUser(User user);
}
