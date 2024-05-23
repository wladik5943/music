package by.tms.music.song;

import lombok.Data;

@Data
public class SongCreateRequest {
    private String name;
    private Long albumId;
    private Long artistId;
    private Long genreId;
}
