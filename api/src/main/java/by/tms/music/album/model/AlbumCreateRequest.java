package by.tms.music.album.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class AlbumCreateRequest {
    private String name;
    private String title;
    private Long artistId;
    private Long genreId;
    private Collection<Long> songsIds;
    private LocalDate year;
}
