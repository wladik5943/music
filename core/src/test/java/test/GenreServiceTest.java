package test;

import by.tms.music.entity.Genre;
import by.tms.music.exception.UniversalException;
import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.mapper.GenreMapper;
import by.tms.music.repository.GenreRepository;
import by.tms.music.service.genre.GenreService;
import by.tms.music.service.genre.impl.GenreServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;
    @Mock
    private GenreMapper genreMapper;
    @InjectMocks
    private GenreServiceImpl genreService;

    @Test
    public void addGenreWhenGenreIsNew(){
        Genre genre = getGenre();
        GenreCreateRequest request = getCreateRequest();
        when(genreMapper.toEntity(any())).thenReturn(genre);
        when(genreRepository.existsByName(any())).thenReturn(false);
        when(genreMapper.toResponse(any())).thenReturn(getGenreResponse());
        lenient().when(genreRepository.save(any())).thenReturn(genre);
        GenreResponse genreResponse = genreService.addGenre(request);
        verify(genreRepository, times(1)).existsByName(any());
        verify(genreRepository, times(1)).save(any());
        assertEquals("pop", genreResponse.getName());
    }

    @Test
    public void addGenreWhenGenreIsExisting(){
        Genre genre = getGenre();
        GenreCreateRequest request = getCreateRequest();
        when(genreMapper.toEntity(any())).thenReturn(genre);
        when(genreRepository.existsByName(any())).thenReturn(true);
        Exception exception = assertThrows(UniversalException.class, () -> genreService.addGenre(request));
        assertEquals("Genre already exists", exception.getMessage());
    }

    private GenreResponse getGenreResponse(){
        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setName("pop");
        return genreResponse;
    }

    private Genre getGenre(){
        Genre genre = new Genre();
        genre.setName("pop");
        return genre;
    }

    private GenreCreateRequest getCreateRequest(){
        GenreCreateRequest request = new GenreCreateRequest();
        request.setName("pop");
        return request;
    }

}
