package by.tms.music.song.contract;

import by.tms.music.song.model.SongCreateRequest;
import by.tms.music.song.model.SongResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("song")
public interface SongRestApi {

    @Transactional
    @PostMapping
    public SongResponse add(@RequestBody SongCreateRequest request);

    @Transactional
    @PostMapping("/favorite")
    public SongResponse addFavorite(@RequestParam Long songId);

    @GetMapping("/favorite")
    public Collection<SongResponse> getFavoriteSongs();

    @DeleteMapping("/favorite")
    public void removeFavorite(@RequestParam Long songId);

    @GetMapping("/findByArtistId/{id}")
    public Page<SongResponse> getSongByArtistId(Pageable pageable, @PathVariable("id") Long artistId);

    @GetMapping("/song/{id}")
    public SongResponse getSongById(@PathVariable("id") Long id);
}
