package by.tms.music.security;
import by.tms.music.security.service.impl.SignServiceImpl;
import by.tms.music.token.JwtAuthenticationResponse;
import by.tms.music.user.model.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("oath")
public class JwtController {

private final SignServiceImpl signService;


@PostMapping("/sign-in")
public JwtAuthenticationResponse signIn(@RequestBody UserCreateRequest userCreateRequest) {
return null;
}
}
