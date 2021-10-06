package org.alex.userapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: UserDTO
 * @Description:
 * @Author: Alexander Konstantinov
 * @Create: 10/6/21
 */

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("email")
    private String email;

    public UserDTO(@JsonProperty("name") String name, @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }
}
