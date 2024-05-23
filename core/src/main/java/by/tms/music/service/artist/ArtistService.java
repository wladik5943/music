package by.tms.music.service.artist;

import by.tms.music.artist.ArtistCreateRequest;
import by.tms.music.artist.ArtistResponse;

public interface ArtistService {
    public ArtistResponse add(ArtistCreateRequest request);
    public ArtistResponse getArtist(Long id);
    public ArtistResponse deleteById(Long id);
}
