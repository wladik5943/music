package by.tms.music.controller;

import by.tms.music.entity.Subscription;
import by.tms.music.entity.User;
import by.tms.music.exception.UniversalException;
import by.tms.music.service.subscription.SubscriptionService;
import by.tms.music.song.SongResponse;
import by.tms.music.subscription.SubscriptionCreateRequest;
import by.tms.music.subscription.SubscriptionResponse;
import by.tms.music.user.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("subscription")
public class SubscriptionRestController {

    private final SubscriptionService subscriptionService;

    @Transactional
    @PostMapping("/add")
    public SubscriptionResponse addSubscription(@RequestBody SubscriptionCreateRequest subscription) {
        return subscriptionService.add(subscription);
    }

    @GetMapping("/subcription/{id}")
    public SubscriptionResponse getSubscriptionById(@PathVariable Long id) {
        SubscriptionResponse subscriptionResponse = subscriptionService.getSubcription(id);
        if(subscriptionResponse == null)
            throw new UniversalException("подписка отсутствует");
        return subscriptionResponse;

    }

}
