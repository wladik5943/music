package by.tms.music.config;

import by.tms.music.entity.Subscription;
import by.tms.music.service.subscription.SubscriptionService;
import by.tms.music.service.subscription.impl.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SubscriptionScheduler {

    private final SubscriptionServiceImpl subscriptionService;

    @Transactional
    @Scheduled(fixedDelay = 10000)
    public void checkSubscriptions() {
        List<Long> expiredSubscriptions = subscriptionService.getExpiredSubscriptions();
        expiredSubscriptions.forEach(subscriptionService::deleteExpiredSubscriptions);
    }

}
