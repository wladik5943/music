package by.tms.music.subscription;

import by.tms.music.rate.RateResponse;
import by.tms.music.user.UserResponse;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SubscriptionResponse {
    private Long id;
    private UserResponse user;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private RateResponse rate;

}
