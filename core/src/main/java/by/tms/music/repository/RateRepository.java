package by.tms.music.repository;

import by.tms.music.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
