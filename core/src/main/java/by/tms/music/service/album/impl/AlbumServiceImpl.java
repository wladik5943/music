package by.tms.music.service.album.impl;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import by.tms.music.album.model.AlbumUpdateRequest;
import by.tms.music.entity.Album;
import by.tms.music.mapper.AlbumMapper;
import by.tms.music.repository.AlbumRepository;
import by.tms.music.repository.ArtistRepository;
import by.tms.music.repository.GenreRepository;
import by.tms.music.repository.SongRepository;
import by.tms.music.service.album.AlbumService;
import by.tms.music.service.song.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    private final ArtistRepository artistRepository;
    private final GenreRepository genreRepository;
    private final SongRepository songRepository;
    private final SongService songService;

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

    @Override
    public AlbumResponse updateAlbum(AlbumUpdateRequest request) {
        Optional<Album> album = albumRepository.findById(request.getId());
        album.ifPresent(album1 -> {
            album1.setName(request.getName());
            album1.setGenre(genreRepository.findById(request.getGenreId()).orElse(null));
            album1.setArtist(artistRepository.findById(request.getArtistId()).orElse(null));
            album1.setTitle(request.getTitle());
            album1.setSongs(songRepository.findAllById(request.getSongsIds()));
            album1.setYear(request.getYear());
            albumRepository.saveAndFlush(album1);
        });
        return albumMapper.toResponse(album.get());
    }
}
