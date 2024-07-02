package test;

import by.tms.music.Main;
import by.tms.music.entity.Song;
import by.tms.music.entity.User;
import by.tms.music.mapper.SongMapper;
import by.tms.music.mapper.UserMapper;
import by.tms.music.repository.SongRepository;
import by.tms.music.repository.UserRepository;
import by.tms.music.service.user.impl.UserServiceImpl;
import by.tms.music.user.model.UserCreateRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
public class UserServiceTest {

    @Autowired
    private PasswordEncoder standardPasswordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private SongMapper songMapper;

    private final String  login = "aaaa";

    private final String password = "bbbb";

    private final String songName = "cccc";

    @Test
    public void registerUserWhenLoginNotExist() {
        UserCreateRequest request = getUserCreateRequest(login,password);
        User register = userService.register(request);
        assertEquals(register, getUser(login, password));

    }

    private UserCreateRequest getUserCreateRequest(String login, String password) {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setLogin(login);
        userCreateRequest.setPassword(password);
        return userCreateRequest;
    }


    private User getUser(String login, String password){
        User user = new User();
        user.setId(1L);
        user.setLogin(login);
        String encodingString=standardPasswordEncoder.encode(password);
        user.setPassword(encodingString);
        return user;
    }

    private Collection<Song> getFavoriteSongs(String songName){
        Collection<Song> songs = new LinkedList<>();
        Song song = new Song();
        song.setId(1L);
        song.setName(songName);
        songs.add(song);
        return songs;
    }



}
