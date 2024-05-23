package by.tms.music.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
@Entity
@Table(schema = "music", name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Genre genre;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private Collection<Song> songs;

    private LocalDate year;
}
