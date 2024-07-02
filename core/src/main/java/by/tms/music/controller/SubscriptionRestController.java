package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.service.subscription.SubscriptionService;
import by.tms.music.subscription.contract.SubscriptionRestAPI;
import by.tms.music.subscription.model.SubscriptionCreateRequest;
import by.tms.music.subscription.model.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubscriptionRestController implements SubscriptionRestAPI {

    private final SubscriptionService subscriptionService;

   @Override
    public SubscriptionResponse addSubscription(@RequestBody SubscriptionCreateRequest subscription) {
        return subscriptionService.add(subscription);
    }

    @Override
    public SubscriptionResponse getSubscriptionById() {
        SubscriptionResponse subscriptionResponse = subscriptionService.getSubcription();
        if(subscriptionResponse == null)
            throw new UniversalException("подписка отсутствует");
        return subscriptionResponse;

    }

}
