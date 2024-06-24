package by.tms.music.album.contact;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("album")
public interface AlbumRestAPI {


    @Transactional
    @PostMapping("/add")
    public AlbumResponse addAlbum(@RequestBody AlbumCreateRequest request);

    @GetMapping("/get/{id}")
    public AlbumResponse getAlbum(@PathVariable Long id);

    @DeleteMapping("delete/{id}")
    public void deleteAlbum(@PathVariable Long id);
}
