package by.tms.music.user;

import lombok.Data;

@Data
public class UserUpdateRequest extends UserCreateRequest{
    private Long id;
}
