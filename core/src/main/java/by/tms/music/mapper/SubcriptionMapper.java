package by.tms.music.mapper;

import by.tms.music.entity.Rate;
import by.tms.music.entity.Subscription;
import by.tms.music.entity.User;
import by.tms.music.rate.RateResponse;
import by.tms.music.subscription.SubscriptionCreateRequest;
import by.tms.music.subscription.SubscriptionResponse;
import by.tms.music.user.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubcriptionMapper {


    SubscriptionResponse toResponse(Subscription subscription);

    @Mapping(target = "subscriptions", ignore = true)
    RateResponse toRateResponse(Rate rate);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "favoriteSongs", ignore = true)
    @Mapping(target = "subscription", ignore = true)
    UserResponse toUserResponse(User user);

    Subscription toEntity(SubscriptionCreateRequest subscriptionCreateRequest);

}
