package by.tms.music.mapper;

import by.tms.music.album.model.AlbumResponse;
import by.tms.music.entity.Album;
import by.tms.music.entity.Genre;
import by.tms.music.entity.Song;
import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.song.model.SongResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GenreMapper {


    GenreResponse toResponse(Genre genre);

    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "artist", ignore = true)
    AlbumResponse toAlbumResponse(Album album);

    @Mapping(target = "artist", ignore = true)
    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "album", ignore = true)
    SongResponse toSongResponse(Song song);


    Genre toEntity(GenreCreateRequest request);
}
