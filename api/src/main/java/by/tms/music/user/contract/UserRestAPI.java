package by.tms.music.user.contract;

import by.tms.music.song.model.SongResponse;
import by.tms.music.user.model.UserCreateRequest;
import by.tms.music.user.model.UserResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("user")
public interface UserRestAPI {

    @Transactional
    @PostMapping
    public UserResponse register(@RequestBody UserCreateRequest createRequest);

    @Transactional
    @PostMapping("/favorite")
    public SongResponse addFavorite(@RequestParam Long userId, @RequestParam Long songId);

    @PostMapping("/auth")
    public UserResponse auth(@RequestParam String login, @RequestParam String password);

    @GetMapping
    public Collection<UserResponse> getUsers();

    @GetMapping("/favorite")
    public Collection<SongResponse> getFavoriteSongs(@RequestParam Long userId);

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id);

    @DeleteMapping("/favorite")
    public void removeFavorite(@RequestParam Long userId, @RequestParam Long songId);
}
