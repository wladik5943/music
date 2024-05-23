package by.tms.music.controller;

import by.tms.music.album.AlbumCreateRequest;
import by.tms.music.album.AlbumResponse;
import by.tms.music.entity.Album;
import by.tms.music.exception.UniversalException;
import by.tms.music.service.album.AlbumService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("album")
public class AlbumRestController {
    private final AlbumService albumService;

    @Transactional
    @PostMapping("/add")
    public AlbumResponse addAlbum(@RequestBody AlbumCreateRequest request) {
        return albumService.addAlbum(request);
    }

    @GetMapping("/get/{id}")
    public AlbumResponse getAlbum(@PathVariable Long id) {
        var album = albumService.getAlbum(id);
        if (album == null) {
            throw new UniversalException("Album not found");
        }
        return album;
    }
}
