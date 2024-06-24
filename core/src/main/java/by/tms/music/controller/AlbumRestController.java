package by.tms.music.controller;

import by.tms.music.album.contact.AlbumRestAPI;
import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import by.tms.music.exception.UniversalException;
import by.tms.music.service.album.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AlbumRestController implements AlbumRestAPI {
    private final AlbumService albumService;


    @Override
    public AlbumResponse addAlbum(@RequestBody AlbumCreateRequest request) {
        return albumService.addAlbum(request);
    }

    @Override
    public AlbumResponse getAlbum(@PathVariable Long id) {
        var album = albumService.getAlbum(id);
        if (album == null) {
            throw new UniversalException("Album not found");
        }
        return album;
    }

    @Override
    public void deleteAlbum(Long id) {
        albumService.deleteAlbum(id);
    }
}
