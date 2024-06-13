package by.tms.music.mapper;

import by.tms.music.album.model.AlbumResponse;
import by.tms.music.artist.model.ArtistCreateRequest;
import by.tms.music.artist.model.ArtistResponse;
import by.tms.music.entity.Album;
import by.tms.music.entity.Artist;
import by.tms.music.entity.Song;
import by.tms.music.song.model.SongResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    ArtistResponse toResponse(Artist artist);

    @Mapping(target = "artist", ignore = true)
    @Mapping(target = "album", ignore = true)
    @Mapping(target = "genre", ignore = true)
    SongResponse toSongResponse(Song song);

    @Mapping(target = "genre", ignore = true)
    @Mapping(target = "artist", ignore = true)
    AlbumResponse toAlbumResponse(Album album);

     Artist toEntity(ArtistCreateRequest artistCreateRequest);

}
