package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.service.user.UserServise;
import by.tms.music.song.SongResponse;
import by.tms.music.user.UserCreateRequest;
import by.tms.music.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserRestController {

    private final UserServise userServise;

    @Transactional
    @PostMapping
    public UserResponse register(@RequestBody UserCreateRequest createRequest) {
        return userServise.register(createRequest);
    }
    @Transactional
    @PostMapping("/favorite")
    public SongResponse addFavorite(@RequestParam Long userId, @RequestParam Long songId) {
        return userServise.addFavoriteSong(songId, userId);
    }
    @PostMapping("/auth")
    public UserResponse auth(@RequestParam String login, @RequestParam String password) {
        return userServise.authorization(login, password);
    }


    @GetMapping
    private Collection<UserResponse> getUsers() {
        return userServise.getUsers();
    }

    @GetMapping("/favorite")
    public Collection<SongResponse> getFavoriteSongs(@RequestParam Long userId) {
        return userServise.getFavoriteSongs(userId);
    }
    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        var user = userServise.getUserById(id);
        if(user == null) {
            throw new UniversalException("пльзователь не существует");
        }
        return user;
    }


    @DeleteMapping("/favorite")
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long songId) {
        userServise.deleteFavoriteSong(songId, userId);
    }


}
