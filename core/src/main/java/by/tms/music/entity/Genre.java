package by.tms.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(schema = "music", name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "genre")
    private Collection<Album> albums;
    @OneToMany(mappedBy = "genre")
    private Collection<Song> songs;
}
