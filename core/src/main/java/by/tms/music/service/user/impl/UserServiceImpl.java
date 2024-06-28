package by.tms.music.service.user.impl;

import by.tms.music.entity.Song;
import by.tms.music.entity.User;
import by.tms.music.exception.UniversalException;
import by.tms.music.mapper.SongMapper;
import by.tms.music.mapper.UserMapper;
import by.tms.music.repository.SongRepository;
import by.tms.music.repository.UserRepository;
import by.tms.music.service.user.UserServise;
import by.tms.music.song.model.SongResponse;
import by.tms.music.user.model.UserCreateRequest;
import by.tms.music.user.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServise {

    private final PasswordEncoder standardPasswordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    @Transactional
    public User register(UserCreateRequest createRequest) {
        var user = userMapper.toEntity(createRequest);
        String encodingString=standardPasswordEncoder.encode(createRequest.getPassword());
        user.setPassword(encodingString);
        User byLogin = userRepository.findByLogin(createRequest.getLogin());
        if (byLogin == null)
            return userRepository.save(user);
        else
            throw new UniversalException("данный логин уже занят", 400);
    }

    @Override
    public Collection<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public SongResponse addFavoriteSong(Long songId) {
        User userByToken = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(userByToken.getId());
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
    public Collection<SongResponse> getFavoriteSongs() {
        User userByToken = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(userByToken.getId());
        return user.get().getFavoriteSongs().stream().map(songMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteFavoriteSong(Long songId) {
        User userByToken = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(userByToken.getId());
        Optional<Song> song = songRepository.findById(songId);
        user.ifPresent(user1 -> {user1.getFavoriteSongs().remove(song.get());});
        userRepository.save(user.get());
        userRepository.flush();
    }



    @Override
    public UserResponse getUserById(Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        if (byId.isPresent())
            return userMapper.toResponse(byId.get());
        else
            throw new UniversalException("user not found", 400);
    }
//    сделать exeption и метод должен ее выбрасывать

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    @Override
    public UserResponse editPassword(String password) {
        User userByToken = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userRepository.findById(userByToken.getId());
        String encodingString=standardPasswordEncoder.encode(password);
        user.ifPresent(u -> { u.setPassword(encodingString);});
        userRepository.saveAndFlush(user.get());
        return userMapper.toResponse(user.get());
    }

}
