package by.tms.music.artist.contract;

import by.tms.music.artist.model.ArtistCreateRequest;
import by.tms.music.artist.model.ArtistResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("artist")
public interface ArtistRestAPI {

    @Transactional
    @PostMapping
    public ArtistResponse add(@RequestBody ArtistCreateRequest request);

    @GetMapping("/get/{id}")
    public ArtistResponse get(@PathVariable Long id);

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ArtistResponse delete(@PathVariable Long id);
}
