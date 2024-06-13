package by.tms.music.album.model;

import by.tms.music.artist.model.ArtistResponse;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.song.model.SongResponse;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class AlbumResponse {
    private Long id;
    private String name;
    private String title;
    private ArtistResponse artist;
    private GenreResponse genre;
    private Collection<SongResponse> songs;
    private LocalDate year;
}
