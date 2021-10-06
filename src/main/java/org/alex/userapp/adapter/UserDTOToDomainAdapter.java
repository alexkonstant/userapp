package org.alex.userapp.adapter;

import org.alex.userapp.domain.User;
import org.alex.userapp.dto.UserDTO;

/**
 * @ClassName: UserDTOToDomainAdapter
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */
public class UserDTOToDomainAdapter {

    /**
     * @param userDTO User DTO model that will be converted to {@link User} object
     * @return {@link User} object
     */
    public static User adapt(final UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getEmail());
    }
}
