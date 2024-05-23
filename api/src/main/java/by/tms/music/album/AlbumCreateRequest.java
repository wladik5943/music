package by.tms.music.album;

import by.tms.music.artist.ArtistUpdateRequest;
import by.tms.music.genre.GenreResponse;
import by.tms.music.genre.GenreUpdateRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbumCreateRequest {
    private String name;
    private String title;
    private Long artistId;
    private Long genreId;
    private LocalDate year;
}
