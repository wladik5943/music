package by.tms.music.repository;

import by.tms.music.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("select u from Subscription u where u.user.id =:id ")
    Subscription findByUserId(@Param("id") Long userId);

    @Query("SELECT s.id FROM Subscription s WHERE s.endDate < :date and s.endTime < :time")
    List<Long> findExpiredSubscriptions(@Param("date") LocalDate date, @Param("time") LocalTime time);

    @Modifying
    @Query("delete FROM Subscription s WHERE s.id = :id")
    void deleteExpiredSubscription(@Param("id") Long id);
}
