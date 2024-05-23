package by.tms.music.rate;

import by.tms.music.subscription.SubscriptionUpdateRequest;
import lombok.Data;

import java.util.Collection;

@Data
public class RateCreateRequest {
    private String description;
    private Double price;
    private Collection<Long> subscriptionsId;
}
