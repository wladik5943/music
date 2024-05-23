package by.tms.music.service.rate.impl;

import by.tms.music.mapper.RateMapper;
import by.tms.music.rate.RateCreateRequest;
import by.tms.music.rate.RateResponse;
import by.tms.music.repository.RateRepository;
import by.tms.music.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RateServiceImpl implements RateService {
    private final RateRepository rateRepository;
    private final RateMapper rateMapper;
    @Override
    public RateResponse addRate(RateCreateRequest request) {
        var rate = rateMapper.toEntity(request);
        return rateMapper.toResponse(rateRepository.save(rate));
    }

    @Override
    public RateResponse getRate(Long id) {
        return rateMapper.toResponse(rateRepository.findById(id).orElse(null));
    }
}
