package iu.maue.ffm.pojo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class UserCreateRequest {

    @NotBlank(message = "username is not null")
    @Size(min =4, max = 64, message = "username length must be [4,64]")
    private String username;

    @NotBlank(message = "password is not null")
    @Size(min =4, max = 64, message = "password length must be [4,64]")
    private String password;

    private String nickname;

    private String gender;
}
