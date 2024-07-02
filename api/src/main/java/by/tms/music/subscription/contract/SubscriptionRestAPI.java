package by.tms.music.subscription.contract;

import by.tms.music.subscription.model.SubscriptionCreateRequest;
import by.tms.music.subscription.model.SubscriptionResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("subscription")
public interface SubscriptionRestAPI {

    @Transactional
    @PostMapping("/add")
    public SubscriptionResponse addSubscription(@RequestBody SubscriptionCreateRequest subscription);

    @GetMapping("/get")
    public SubscriptionResponse getSubscriptionById();
}
