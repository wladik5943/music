package by.tms.music.repository;

import by.tms.music.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>, JpaSpecificationExecutor<Song> {

    @Query("select s from Song s where :artistId is null or s.artist.id =: artistId ")
    public Page<Song> findByArtistId(Pageable pageable, @Param("artistId") Long artistId);

}
