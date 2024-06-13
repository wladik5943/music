package by.tms.music.rate.contract;

import by.tms.music.rate.model.RateCreateRequest;
import by.tms.music.rate.model.RateResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rate")
public interface RateRestAPI {

    @Transactional
    @PostMapping("/add")
    public RateResponse add(@RequestBody RateCreateRequest request);

    @GetMapping("/get/{id}")
    public RateResponse get(@PathVariable Long id);
}
