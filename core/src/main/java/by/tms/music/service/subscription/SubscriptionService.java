package by.tms.music.service.subscription;

import by.tms.music.entity.Subscription;
import by.tms.music.entity.User;
import by.tms.music.subscription.SubscriptionCreateRequest;
import by.tms.music.subscription.SubscriptionResponse;
import by.tms.music.subscription.SubscriptionUpdateRequest;
import by.tms.music.user.UserUpdateRequest;

public interface SubscriptionService {
    public SubscriptionResponse add(SubscriptionCreateRequest request);
    public SubscriptionResponse getSubcription(Long id);
}
