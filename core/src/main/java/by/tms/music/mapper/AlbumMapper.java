package by.tms.music.mapper;

import by.tms.music.album.AlbumCreateRequest;
import by.tms.music.album.AlbumResponse;
import by.tms.music.artist.ArtistResponse;
import by.tms.music.entity.Album;
import by.tms.music.entity.Artist;
import by.tms.music.entity.Genre;
import by.tms.music.genre.GenreResponse;
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

    public Album toEntity(AlbumCreateRequest albumCreateRequest);
}
