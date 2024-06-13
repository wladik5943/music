package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.genre.contract.GenreRestAPI;
import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GenreRestController implements GenreRestAPI {

    private final GenreService genreService;

    @Override
    public GenreResponse addGenre(@RequestBody GenreCreateRequest request){
        return genreService.addGenre(request);
    }

    @Override
    public GenreResponse getGenre(@PathVariable Long id){
        var genre =  genreService.getGenre(id);
        if(genre == null){
            throw new UniversalException("жанр не существует");
        }
        return genre;
    }
}
