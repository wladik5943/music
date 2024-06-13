package by.tms.music.song.model;

import by.tms.music.album.model.AlbumResponse;
import by.tms.music.artist.model.ArtistResponse;
import by.tms.music.genre.model.GenreResponse;
import lombok.Data;

@Data
public class SongResponse {
    private Long id;
    private String name;
    private AlbumResponse album;
    private ArtistResponse artist;
    private GenreResponse genre;
}
