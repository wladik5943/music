package by.tms.music.service.rate;

import by.tms.music.rate.model.RateCreateRequest;
import by.tms.music.rate.model.RateResponse;

public interface RateService {
    public RateResponse addRate(RateCreateRequest request);
    public RateResponse getRate(Long id);
}
