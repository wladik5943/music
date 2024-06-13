package by.tms.music.song.model;

import lombok.Data;

@Data
public class SongUpdateRequest extends SongCreateRequest{
    private Long id;
}
