package by.tms.music.controller;

import by.tms.music.artist.contract.ArtistRestAPI;
import by.tms.music.artist.model.ArtistCreateRequest;
import by.tms.music.artist.model.ArtistResponse;
import by.tms.music.exception.UniversalException;
import by.tms.music.service.artist.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArtistRestController implements ArtistRestAPI {

    private final ArtistService artistService;

    @Override
    public ArtistResponse add(@RequestBody ArtistCreateRequest request){
        return artistService.add(request);
    }

    @Override
    public ArtistResponse get(@PathVariable Long id){
        var artist = artistService.getArtist(id);
        if(artist == null){
            throw new UniversalException("Artist not found");
        }
        return artist;
    }

    @Override
    public ArtistResponse delete(@PathVariable Long id){
        var artist = artistService.deleteById(id);
        if(artist == null){
            throw new UniversalException("Artist not found");
        }
        return artist;
    }
}
