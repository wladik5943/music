package by.tms.music.genre.contract;

import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("genre")
public interface GenreRestAPI {

    @Transactional
    @PostMapping("/add")
    public GenreResponse addGenre(@RequestBody GenreCreateRequest request);

    @GetMapping("/get/{id}")
    public GenreResponse getGenre(@PathVariable Long id);
}
