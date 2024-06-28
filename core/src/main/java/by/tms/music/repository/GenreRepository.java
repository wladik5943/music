package by.tms.music.repository;

import by.tms.music.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select case when count(u) > 0 then true else false end from Genre u where u.name = :name")
    Boolean existsByName(@Param("name") String name);
}
