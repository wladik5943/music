package by.tms.music.entity;

import by.tms.music.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(schema = "music",name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Subscription subscription;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "favorite_song",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Collection<Song> favoriteSongs;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
