package by.tms.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(schema = "music", name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Genre genre;
    @ManyToMany(mappedBy = "favoriteSongs")
    private Collection<User> users;
}

