package by.tms.music.service.song;

import by.tms.music.song.SongCreateRequest;
import by.tms.music.song.SongResponse;

import java.util.Collection;

public interface SongService {

    public SongResponse add(SongCreateRequest request);
    public Collection<SongResponse> getSongsByArtistId(Long artistId);
    public SongResponse getSongById(Long id);
}
