package by.tms.music.song;

import lombok.Data;

@Data
public class SongUpdateRequest extends SongCreateRequest{
    private Long id;
}
