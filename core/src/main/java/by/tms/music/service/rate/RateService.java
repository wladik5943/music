package by.tms.music.service.rate;

import by.tms.music.rate.RateCreateRequest;
import by.tms.music.rate.RateResponse;

public interface RateService {
    public RateResponse addRate(RateCreateRequest request);
    public RateResponse getRate(Long id);
}
