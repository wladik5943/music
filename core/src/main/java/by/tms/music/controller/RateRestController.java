package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.rate.contract.RateRestAPI;
import by.tms.music.rate.model.RateCreateRequest;
import by.tms.music.rate.model.RateResponse;
import by.tms.music.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RateRestController implements RateRestAPI {

    private final RateService rateService;

    @Override
    public RateResponse add(@RequestBody RateCreateRequest request){
        return rateService.addRate(request);
    }


    @Override
    public RateResponse get(@PathVariable Long id){
        var rate = rateService.getRate(id);
        if(rate == null){
            throw new UniversalException("Rate not found");
        }
        return rate;
    }
}
