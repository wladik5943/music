package by.tms.music.service.subscription.impl;

import by.tms.music.entity.Subscription;
import by.tms.music.entity.User;
import by.tms.music.exception.UniversalException;
import by.tms.music.mapper.SubcriptionMapper;
import by.tms.music.mapper.UserMapper;
import by.tms.music.repository.RateRepository;
import by.tms.music.repository.SubscriptionRepository;
import by.tms.music.repository.UserRepository;
import by.tms.music.service.subscription.SubscriptionService;
import by.tms.music.subscription.model.SubscriptionCreateRequest;
import by.tms.music.subscription.model.SubscriptionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubcriptionMapper subscriptionMapper;
    private final RateRepository rateRepository;
    private final UserMapper userMapper;

    @Override
    public SubscriptionResponse add(SubscriptionCreateRequest request) {

        var subscription = subscriptionMapper.toEntity(request);
        User userByToken = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(subscriptionRepository.findByUserId(userByToken.getId()) != null){
            throw new UniversalException("у данного пользователя уже существует подписка");
        }
        Optional<User> user = userRepository.findById(userByToken.getId());
        subscription.setUser(user.get());
        subscription.setRate(rateRepository.findById(request.getRateId()).orElse(null));
        subscription.setStartDate(request.getStartDate());
        subscription.setEndDate(request.getEndDate());
        subscription.setStartTime(request.getStartTime());
        subscription.setEndTime(request.getEndTime());
        return subscriptionMapper.toResponse(subscriptionRepository.save(subscription));
    }

    @Override
    public SubscriptionResponse getSubcription() {
        User userByToken = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return subscriptionMapper.toResponse(subscriptionRepository.findById(userByToken.getId()).orElse(null));
    }


    public List<Long> getExpiredSubscriptions() {
        return subscriptionRepository.findExpiredSubscriptions(LocalDate.now(), LocalTime.now());
    }

    public void deleteExpiredSubscriptions(Long id) {
        subscriptionRepository.deleteExpiredSubscription(id);
    }
}
