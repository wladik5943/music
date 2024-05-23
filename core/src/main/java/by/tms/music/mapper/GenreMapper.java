package by.tms.music.mapper;

import by.tms.music.album.AlbumResponse;
import by.tms.music.artist.ArtistResponse;
import by.tms.music.entity.Album;
import by.tms.music.entity.Artist;
import by.tms.music.entity.Genre;
import by.tms.music.entity.Song;
import by.tms.music.genre.GenreCreateRequest;
import by.tms.music.genre.GenreResponse;
import by.tms.music.song.SongResponse;
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
