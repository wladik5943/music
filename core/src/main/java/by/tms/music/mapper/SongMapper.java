package by.tms.music.mapper;

import by.tms.music.entity.Album;
import by.tms.music.entity.Song;
import by.tms.music.song.SongCreateRequest;
import by.tms.music.song.SongResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(target = "artist.songs", ignore = true)
    @Mapping(target = "artist.albums", ignore = true)
    @Mapping(target = "album.artist", ignore = true)
    @Mapping(target = "album.genre", ignore = true)
    @Mapping(target = "genre.albums", ignore = true)
    @Mapping(target = "genre.songs", ignore = true)
    SongResponse toResponse(Song song);


    Song toEntity(SongCreateRequest songCreateRequest);
}
