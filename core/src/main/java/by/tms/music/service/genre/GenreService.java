package by.tms.music.service.genre;

import by.tms.music.genre.GenreCreateRequest;
import by.tms.music.genre.GenreResponse;
import by.tms.music.genre.GenreUpdateRequest;

public interface GenreService {
    public GenreResponse addGenre(GenreCreateRequest request);
    public GenreResponse getGenre(Long id);
}
