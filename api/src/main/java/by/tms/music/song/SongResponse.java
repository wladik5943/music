package by.tms.music.song;

import by.tms.music.album.AlbumResponse;
import by.tms.music.artist.ArtistResponse;
import by.tms.music.genre.GenreResponse;
import lombok.Data;

@Data
public class SongResponse {
    private Long id;
    private String name;
    private AlbumResponse album;
    private ArtistResponse artist;
    private GenreResponse genre;
}
