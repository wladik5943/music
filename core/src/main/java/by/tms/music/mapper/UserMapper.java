package by.tms.music.mapper;

import by.tms.music.entity.Rate;
import by.tms.music.entity.Song;
import by.tms.music.entity.User;
import by.tms.music.rate.model.RateResponse;
import by.tms.music.song.model.SongResponse;
import by.tms.music.user.model.UserCreateRequest;
import by.tms.music.user.model.UserResponse;
import by.tms.music.user.model.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "subscription.user",ignore = true)
    UserResponse toResponse(User user);
    User toEntity(UserCreateRequest createRequest);


    @Mapping(target = "subscriptions", ignore = true)
    RateResponse toRateResponse(Rate rate);

    @Mapping(target = "artist", ignore = true)
    @Mapping(target = "album", ignore = true)
    @Mapping(target = "genre", ignore = true)
    SongResponse toSongResponse(Song song);

    User toEntity(UserUpdateRequest updateRequest);
    @Mapping(target = "id", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest updateRequest);
}
