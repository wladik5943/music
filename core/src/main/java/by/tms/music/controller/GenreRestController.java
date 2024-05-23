package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.genre.GenreCreateRequest;
import by.tms.music.genre.GenreResponse;
import by.tms.music.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("genre")
public class GenreRestController {

    private final GenreService genreService;

    @Transactional
    @PostMapping("/add")
    public GenreResponse addGenre(@RequestBody GenreCreateRequest request){
        return genreService.addGenre(request);
    }

    @GetMapping("/get/{id}")
    public GenreResponse getGenre(@PathVariable Long id){
        var genre =  genreService.getGenre(id);
        if(genre == null){
            throw new UniversalException("жанр не существует");
        }
        return genre;
    }
}
