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

//    @Override
//    public UserResponse register(@RequestBody UserCreateRequest createRequest) {
//        return userServise.register(createRequest);
//    }
    @Override
    public SongResponse addFavorite(@RequestParam Long userId, @RequestParam Long songId) {
        return userServise.addFavoriteSong(songId, userId);
    }
    @Override
    public UserResponse auth(@RequestParam String login, @RequestParam String password) {
        return userServise.authorization(login, password);
    }


    @Override
    public Collection<UserResponse> getUsers() {
        return userServise.getUsers();
    }

    @Override
    public Collection<SongResponse> getFavoriteSongs(@RequestParam Long userId) {
        return userServise.getFavoriteSongs(userId);
    }
    @Override
    public UserResponse getUser(@PathVariable Long id) {
        var user = userServise.getUserById(id);
        if(user == null) {
            throw new UniversalException("пльзователь не существует");
        }
        return user;
    }


    @Override
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long songId) {
        userServise.deleteFavoriteSong(songId, userId);
    }


}
