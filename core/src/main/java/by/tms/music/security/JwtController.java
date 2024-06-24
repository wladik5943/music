package by.tms.music.security;
import by.tms.music.security.service.SignService;
import by.tms.music.security.service.impl.SignServiceImpl;
import by.tms.music.token.JwtAuthenticationResponse;
import by.tms.music.user.model.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("oauth")
public class JwtController {

private final SignServiceImpl signService;


    @RequestMapping(value ="/sign-in", method = RequestMethod.POST)
    public JwtAuthenticationResponse signIn(@RequestBody UserCreateRequest userCreateRequest) {
        return signService.signIn(userCreateRequest);
    }


    @RequestMapping(value ="/sign-up", method = RequestMethod.POST)
    public JwtAuthenticationResponse signUp(@RequestBody UserCreateRequest userCreateRequest){
        return signService.signUp(userCreateRequest);
    }
}
