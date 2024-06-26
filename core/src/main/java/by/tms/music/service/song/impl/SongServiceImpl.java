package by.tms.music.service.song.impl;

import by.tms.music.entity.Song;
import by.tms.music.mapper.SongMapper;
import by.tms.music.repository.AlbumRepository;
import by.tms.music.repository.ArtistRepository;
import by.tms.music.repository.GenreRepository;
import by.tms.music.repository.SongRepository;
import by.tms.music.service.song.SongService;
import by.tms.music.song.model.SongCreateRequest;
import by.tms.music.song.model.SongResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final ArtistRepository artistRepository;
    private final GenreRepository genreRepository;
    private final AlbumRepository albumRepository;

    @Override
    public SongResponse add(SongCreateRequest request){
        var song = songMapper.toEntity(request);
        song.setArtist(artistRepository.findById(request.getArtistId()).orElse(null));
        song.setGenre(genreRepository.findById(request.getGenreId()).orElse(null));
        song.setAlbum(albumRepository.findById(request.getAlbumId()).orElse(null));
        return songMapper.toResponse(songRepository.save(song));
    }


    @Override
    public Page<SongResponse> getSongsByArtistId(Long artistId, Pageable pageable) {
        return songRepository.findByArtistId(pageable, artistId).map(songMapper::toResponse);
    }
    @Override
    public SongResponse getSongById(Long id){
        return songMapper.toResponse(songRepository.findById(id).orElse(null));
    }

    @Override
    public Collection<Song> getSongsById(Collection<Long> ids) {
        return songRepository.findAllById(ids);
    }

    public Collection<SongResponse> getSongsByAlbumId(Long albumId){
        Specification<Song> spec = Specification.where(((root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("albumId"), albumId)));
        return songRepository.findAll(spec).stream().map(songMapper::toResponse).toList();
    }
}
