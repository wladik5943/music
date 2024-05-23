package by.tms.music.artist;

import by.tms.music.album.AlbumResponse;
import by.tms.music.song.SongResponse;
import lombok.Data;

import java.util.Collection;

@Data
public class ArtistResponse {
    private Long id;
    private String name;
    private String description;
    private Collection<AlbumResponse> albums;
    private Collection<SongResponse> songs;
}
