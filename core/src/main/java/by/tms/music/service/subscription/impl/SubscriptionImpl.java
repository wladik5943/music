package by.tms.music.service.subscription.impl;

import by.tms.music.mapper.SubcriptionMapper;
import by.tms.music.mapper.UserMapper;
import by.tms.music.repository.RateRepository;
import by.tms.music.repository.SubscriptionRepository;
import by.tms.music.repository.UserRepository;
import by.tms.music.service.subscription.SubscriptionService;
import by.tms.music.subscription.model.SubscriptionCreateRequest;
import by.tms.music.subscription.model.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class SubscriptionImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubcriptionMapper subscriptionMapper;
    private final RateRepository rateRepository;
    private final UserMapper userMapper;

    @Override
    public SubscriptionResponse add(SubscriptionCreateRequest request) {
        var subscription = subscriptionMapper.toEntity(request);
        subscription.setUser(userRepository.findById(request.getUserId()).orElse(null));
        subscription.setRate(rateRepository.findById(request.getRateId()).orElse(null));
        return subscriptionMapper.toResponse(subscriptionRepository.save(subscription));
    }

    @Override
    public SubscriptionResponse getSubcription(Long id) {
        return subscriptionMapper.toResponse(subscriptionRepository.findById(id).orElse(null));
    }
}
