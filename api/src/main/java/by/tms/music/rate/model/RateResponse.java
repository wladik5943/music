package by.tms.music.rate.model;

import by.tms.music.subscription.model.SubscriptionResponse;
import lombok.Data;

import java.util.Collection;
@Data
public class RateResponse {
    private Long id;
    private String description;
    private Double price;
    private Collection<SubscriptionResponse> subscriptions;
}
