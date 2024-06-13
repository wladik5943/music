package by.tms.music.mapper;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import by.tms.music.artist.model.ArtistResponse;
import by.tms.music.entity.Album;
import by.tms.music.entity.Artist;
import by.tms.music.entity.Genre;
import by.tms.music.entity.Song;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.song.model.SongResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    public AlbumResponse toResponse(Album album);

    @Mapping(target = "albums", ignore = true)
    @Mapping(target = "songs", ignore = true)
    ArtistResponse toArtistResponse(Artist artist);

    @Mapping(target = "albums", ignore = true)
    @Mapping(target = "songs", ignore = true)
    GenreResponse toGenreResponse(Genre genre);


    @Mapping(target = "artist", ignore = true)
    @Mapping(target = "album", ignore = true)
    @Mapping(target = "genre", ignore = true)
    SongResponse toSongResponse(Song song);


    public Album toEntity(AlbumCreateRequest albumCreateRequest);
}
