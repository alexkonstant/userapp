package org.alex.userapp.controller;

import org.alex.userapp.domain.User;
import org.alex.userapp.dto.UserDTO;
import org.alex.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user DTO model of user that is being added to DB
     * @return Message with status of DB operation
     */
    @PostMapping
    public String addUser(@RequestBody UserDTO user) {
        return userService.addUser(user);
    }

    /**
     * @return List of existing users from DB
     */
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    /**
     * @param user User object that is being updated
     * @return Message with status of DB operation
     */
    @PutMapping
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * @param user User object that is being deleted
     * @return Message with status of DB operation. If user with specified ID has not been found server will return 500 error.
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") User user) {
        userService.deleteUser(user);
        return "OK";
    }
}
