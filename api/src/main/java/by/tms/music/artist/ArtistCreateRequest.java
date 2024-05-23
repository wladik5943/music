package by.tms.music.artist;

import by.tms.music.album.AlbumResponse;
import by.tms.music.album.AlbumUpdateRequest;
import by.tms.music.song.SongResponse;
import by.tms.music.song.SongUpdateRequest;
import lombok.Data;

import java.util.Collection;

@Data
public class ArtistCreateRequest {
    private String name;
    private String description;
    private Collection<Long> albumsId;
    private Collection<Long> songsId;
}
