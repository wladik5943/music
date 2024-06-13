package by.tms.music.user.model;

import lombok.Data;

@Data
public class UserUpdateRequest extends UserCreateRequest{
    private Long id;
}
