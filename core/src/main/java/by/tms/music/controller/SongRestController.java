package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.service.song.SongService;
import by.tms.music.service.user.UserServise;
import by.tms.music.song.contract.SongRestApi;
import by.tms.music.song.model.SongCreateRequest;
import by.tms.music.song.model.SongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class SongRestController implements SongRestApi {

    private final SongService songService;
    private final UserServise userServise;

    @Override
    public SongResponse add(@RequestBody SongCreateRequest request){
        return songService.add(request);
    }

    @Override
    public SongResponse addFavorite(@RequestParam Long songId) {
        return userServise.addFavoriteSong(songId);
    }

    @Override
    public void removeFavorite(@RequestParam Long songId) {
        userServise.deleteFavoriteSong(songId);
    }

    @Override
    public Collection<SongResponse> getFavoriteSongs() {
        return userServise.getFavoriteSongs();
    }


    @Override
    public Page<SongResponse> getSongByArtistId(Pageable pageable, @PathVariable("id") Long artistId){
        return songService.getSongsByArtistId(artistId, pageable);
    }

    @Override
    public SongResponse getSongById(@PathVariable("id") Long id){
        SongResponse songById = songService.getSongById(id);
        if(songById == null)
            throw new UniversalException("песня не существует");
        return songById;
    }
}
