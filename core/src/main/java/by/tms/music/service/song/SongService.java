package by.tms.music.service.song;

import by.tms.music.song.model.SongCreateRequest;
import by.tms.music.song.model.SongResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    public SongResponse add(SongCreateRequest request);
    public Page<SongResponse> getSongsByArtistId(Long artistId, Pageable pageable);
    public SongResponse getSongById(Long id);
}
