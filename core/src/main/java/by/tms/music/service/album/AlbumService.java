package by.tms.music.service.album;

import by.tms.music.album.AlbumCreateRequest;
import by.tms.music.album.AlbumResponse;
import by.tms.music.entity.Album;

public interface AlbumService {
 public AlbumResponse addAlbum(AlbumCreateRequest request);
 public AlbumResponse getAlbum(Long id);
}
