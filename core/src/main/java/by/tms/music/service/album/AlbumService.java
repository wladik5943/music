package by.tms.music.service.album;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;

public interface AlbumService {
 public AlbumResponse addAlbum(AlbumCreateRequest request);
 public AlbumResponse getAlbum(Long id);
}
