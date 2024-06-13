package by.tms.music.service.artist;

import by.tms.music.artist.model.ArtistCreateRequest;
import by.tms.music.artist.model.ArtistResponse;

public interface ArtistService {
    public ArtistResponse add(ArtistCreateRequest request);
    public ArtistResponse getArtist(Long id);
    public ArtistResponse deleteById(Long id);
}
