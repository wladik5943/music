package by.tms.music.artist.model;

import lombok.Data;

import java.util.Collection;

@Data
public class ArtistCreateRequest {
    private String name;
    private String description;
    private Collection<Long> albumsId;
    private Collection<Long> songsId;
}
