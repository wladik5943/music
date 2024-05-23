package by.tms.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(schema = "music", name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Sequence
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Collection<Album> albums;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private Collection<Song> songs;
}
