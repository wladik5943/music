package by.tms.music.controller;

import by.tms.music.artist.ArtistCreateRequest;
import by.tms.music.artist.ArtistResponse;
import by.tms.music.exception.UniversalException;
import by.tms.music.service.artist.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("artist")
public class ArtistRestController {

    private final ArtistService artistService;

    @Transactional
    @PostMapping
    public ArtistResponse add(@RequestBody ArtistCreateRequest request){
        return artistService.add(request);
    }

    @GetMapping("/get/{id}")
    public ArtistResponse get(@PathVariable Long id){
        var artist = artistService.getArtist(id);
        if(artist == null){
            throw new UniversalException("Artist not found");
        }
        return artist;
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ArtistResponse delete(@PathVariable Long id){
        var artist = artistService.deleteById(id);
        if(artist == null){
            throw new UniversalException("Artist not found");
        }
        return artist;
    }
}
