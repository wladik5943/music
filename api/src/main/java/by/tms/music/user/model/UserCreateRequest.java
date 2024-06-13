package by.tms.music.user.model;

import by.tms.music.enums.UserRole;
import lombok.Data;

@Data
public class UserCreateRequest {
    private String name;
    private String login;
    private String password;
    private UserRole role;
}
