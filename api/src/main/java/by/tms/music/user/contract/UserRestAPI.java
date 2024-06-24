package by.tms.music.user.contract;

import by.tms.music.song.model.SongResponse;
import by.tms.music.user.model.UserCreateRequest;
import by.tms.music.user.model.UserResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("user")
public interface UserRestAPI {

//    @Transactional
//    @PostMapping
//    public UserResponse register(@RequestBody UserCreateRequest createRequest);


    @PostMapping("/editPassword")
    @Transactional
    public UserResponse editPassword(@RequestParam String password);

    @GetMapping
    public Collection<UserResponse> getUsers();


    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id);


}
