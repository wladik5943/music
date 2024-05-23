package by.tms.music.service.artist.impl;

import by.tms.music.artist.ArtistCreateRequest;
import by.tms.music.artist.ArtistResponse;
import by.tms.music.mapper.ArtistMapper;
import by.tms.music.repository.ArtistRepository;
import by.tms.music.service.artist.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    public ArtistResponse add(ArtistCreateRequest request) {
        var artist = artistMapper.toEntity(request);
        return artistMapper.toResponse(artistRepository.save(artist));
    }

    @Override
    public ArtistResponse getArtist(Long id) {
        return artistMapper.toResponse(artistRepository.findById(id).orElse(null));
    }

    public ArtistResponse deleteById(Long id) {
        var artist = artistRepository.findById(id).orElse(null);
        artistRepository.deleteById(id);
        return artistMapper.toResponse(artist);
    }
}
