package by.tms.music.rate;

import by.tms.music.subscription.SubscriptionResponse;
import lombok.Data;

import java.util.Collection;
@Data
public class RateResponse {
    private Long id;
    private String description;
    private Double price;
    private Collection<SubscriptionResponse> subscriptions;
}
