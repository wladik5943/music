package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.service.song.SongService;
import by.tms.music.song.SongCreateRequest;
import by.tms.music.song.SongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("song")
public class SongRestController {

    private final SongService songService;

    @Transactional
    @PostMapping
    public SongResponse add(@RequestBody SongCreateRequest request){
        return songService.add(request);
    }

    @GetMapping("/findByArtistId/{id}")
    public Collection<SongResponse> getSongByArtistId(@PathVariable("id") Long artistId){
        return songService.getSongsByArtistId(artistId);
    }

    @GetMapping("/song/{id}")
    public SongResponse getSongById(@PathVariable("id") Long id){
        SongResponse songById = songService.getSongById(id);
        if(songById == null)
            throw new UniversalException("песня не существует");
        return songById;
    }
}
