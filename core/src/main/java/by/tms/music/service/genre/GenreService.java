package by.tms.music.service.genre;

import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;

public interface GenreService {
    public GenreResponse addGenre(GenreCreateRequest request);
    public GenreResponse getGenre(Long id);
}
