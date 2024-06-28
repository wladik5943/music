package test;

import by.tms.music.Main;
import by.tms.music.entity.Genre;
import by.tms.music.repository.GenreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Main.class)
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    private final String name = "pop";

    @Test
    public void existGenre(){
        Genre genre = getGenre();
        genreRepository.save(genre);
        assertTrue(genreRepository.existsByName(name));
    }

    private Genre getGenre(){
        Genre genre = new Genre();
        genre.setName(name);
        genre.setId(1L);
        return genre;
    }

}
