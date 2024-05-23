package by.tms.music.controller;

import by.tms.music.exception.UniversalException;
import by.tms.music.rate.RateCreateRequest;
import by.tms.music.rate.RateResponse;
import by.tms.music.service.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rate")
public class RateRestController {

    private final RateService rateService;

    @Transactional
    @PostMapping("/add")
    public RateResponse add(@RequestBody RateCreateRequest request){
        return rateService.addRate(request);
    }


    @GetMapping("/get/{id}")
    public RateResponse get(@PathVariable Long id){
        var rate = rateService.getRate(id);
        if(rate == null){
            throw new UniversalException("Rate not found");
        }
        return rate;
    }
}
