package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.service.user.UserServise;
import by.tms.music.song.model.SongResponse;
import by.tms.music.user.contract.UserRestAPI;
import by.tms.music.user.model.UserCreateRequest;
import by.tms.music.user.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class UserRestController implements UserRestAPI {

    private final UserServise userServise;


    @Override
    public UserResponse editPassword(@RequestParam String password) {
        return userServise.editPassword(password);
    }

    @Override
    public Collection<UserResponse> getUsers() {
        return userServise.getUsers();
    }


    @Override
    public UserResponse getUser(@PathVariable Long id) {
        var user = userServise.getUserById(id);
        if(user == null) {
            throw new UniversalException("пльзователь не существует");
        }
        return user;
    }





}
