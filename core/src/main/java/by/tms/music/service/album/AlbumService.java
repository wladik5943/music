package by.tms.music.service.album;

import by.tms.music.album.model.AlbumCreateRequest;
import by.tms.music.album.model.AlbumResponse;
import by.tms.music.album.model.AlbumUpdateRequest;

public interface AlbumService {
 public AlbumResponse addAlbum(AlbumCreateRequest request);
 public AlbumResponse getAlbum(Long id);
 public void deleteAlbum(Long id);
 public AlbumResponse updateAlbum(AlbumUpdateRequest request);
}
