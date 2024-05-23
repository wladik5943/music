package by.tms.music.album;

import by.tms.music.artist.ArtistResponse;
import by.tms.music.genre.GenreResponse;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbumResponse {
    private Long id;
    private String name;
    private String title;
    private ArtistResponse artist;
    private GenreResponse genre;
    private LocalDate year;
}
