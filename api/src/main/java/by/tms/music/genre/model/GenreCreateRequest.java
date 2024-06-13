package by.tms.music.genre.model;

import lombok.Data;

import java.util.Collection;

@Data
public class GenreCreateRequest {
    private String name;
    private String description;
    private Collection<Long> albumsId;
    private Collection<Long> songsId;
}
