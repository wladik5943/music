package by.tms.music.service.user;

import by.tms.music.song.SongResponse;
import by.tms.music.user.UserCreateRequest;
import by.tms.music.user.UserResponse;

import java.util.Collection;


public interface UserServise {
    public UserResponse register(UserCreateRequest user);
    public Collection<UserResponse> getUsers();
    public SongResponse addFavoriteSong(Long songId, Long userId);
    public Collection<SongResponse> getFavoriteSongs(Long userId);
    public void deleteFavoriteSong(Long songId, Long userId);
    public UserResponse authorization(String login, String password);
    public UserResponse getUserById(Long userId);
}
