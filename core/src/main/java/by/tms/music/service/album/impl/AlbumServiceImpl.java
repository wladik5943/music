package by.tms.music.service.album.impl;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import by.tms.music.mapper.AlbumMapper;
import by.tms.music.repository.AlbumRepository;
import by.tms.music.repository.ArtistRepository;
import by.tms.music.repository.GenreRepository;
import by.tms.music.service.album.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final ArtistRepository artistRepository;
    private final GenreRepository genreRepository;

    @Override
    public AlbumResponse addAlbum(AlbumCreateRequest request) {
        var album = albumMapper.toEntity(request);
        album.setArtist(artistRepository.findById(request.getArtistId()).orElse(null));
        album.setGenre(genreRepository.findById(request.getGenreId()).orElse(null));
        return albumMapper.toResponse(albumRepository.save(album));
    }

    @Override
    public AlbumResponse getAlbum(Long id) {
        return albumMapper.toResponse(albumRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
