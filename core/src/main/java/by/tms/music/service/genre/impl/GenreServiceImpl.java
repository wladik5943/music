package by.tms.music.service.genre.impl;

import by.tms.music.exception.UniversalException;
import by.tms.music.genre.model.GenreCreateRequest;
import by.tms.music.genre.model.GenreResponse;
import by.tms.music.mapper.GenreMapper;
import by.tms.music.repository.GenreRepository;
import by.tms.music.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final GenreMapper genreMapper;

    @Override
    public GenreResponse addGenre(GenreCreateRequest request) {
        var genre = genreMapper.toEntity(request);
        if (genreRepository.existsByName(genre.getName())) {
            throw new UniversalException("Genre already exists");
        }
        return genreMapper.toResponse(genreRepository.save(genre));
    }

    @Override
    public GenreResponse getGenre(Long id) {
        return genreMapper.toResponse(genreRepository.findById(id).orElse(null));
    }
}
