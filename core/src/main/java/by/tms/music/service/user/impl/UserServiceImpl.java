package by.tms.music.service.user.impl;

import by.tms.music.entity.Song;
import by.tms.music.entity.User;
import by.tms.music.exception.UniversalException;
import by.tms.music.mapper.SongMapper;
import by.tms.music.mapper.UserMapper;
import by.tms.music.repository.SongRepository;
import by.tms.music.repository.UserRepository;
import by.tms.music.service.user.UserServise;
import by.tms.music.song.SongCreateRequest;
import by.tms.music.song.SongResponse;
import by.tms.music.user.UserCreateRequest;
import by.tms.music.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServise {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    public UserResponse register(UserCreateRequest createRequest) {
        var user = userMapper.toEntity(createRequest);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public Collection<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public SongResponse addFavoriteSong(Long songId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Song> song = songRepository.findById(songId);
        user.ifPresent(user1 -> {user1.getFavoriteSongs().stream().
                forEach(x ->
                {if(x == song.get())
                    throw new UniversalException("песня уже есть в списке");
                });
            user1.getFavoriteSongs().add(song.get());}); //дописать проверку на уникальность
        userRepository.saveAndFlush(user.get());
        return songMapper.toResponse(song.get());
    }
    @Override
    public Collection<SongResponse> getFavoriteSongs(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get().getFavoriteSongs().stream().map(songMapper::toResponse).collect(Collectors.toList());
    }
    @Override
    public void deleteFavoriteSong(Long songId, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Song> song = songRepository.findById(songId);
        user.ifPresent(user1 -> {user1.getFavoriteSongs().remove(song.get());});
        userRepository.save(user.get());
        userRepository.flush();
    }

    @Override
    public UserResponse authorization(String login, String password) {
        var user = userRepository.findByLogin(login);
        if (user == null){
            throw new UniversalException("Пользователь не найден");
        }
        if(user.getPassword().equals(password)){
            return userMapper.toResponse(user);
        }
        throw new UniversalException("неверный пароль");
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return userMapper.toResponse(userRepository.findById(userId).get());
    }
//    сделать exeption и метод должен ее выбрасывать


}
