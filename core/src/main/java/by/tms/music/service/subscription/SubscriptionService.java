package by.tms.music.service.subscription;

import by.tms.music.subscription.model.SubscriptionCreateRequest;
import by.tms.music.subscription.model.SubscriptionResponse;

public interface SubscriptionService {
    public SubscriptionResponse add(SubscriptionCreateRequest request);
    public SubscriptionResponse getSubcription(Long id);
}
