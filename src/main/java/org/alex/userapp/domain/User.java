package org.alex.userapp.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: User
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User clone(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        return this;
    }
}
