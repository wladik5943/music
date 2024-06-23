package by.tms.music.security.service.impl;

import by.tms.music.repository.UserRepository;
import by.tms.music.security.service.SignService;
import by.tms.music.service.user.impl.UserServiceImpl;
import by.tms.music.token.JwtAuthenticationResponse;
import by.tms.music.user.model.UserCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtService;

    public JwtAuthenticationResponse signUp(UserCreateRequest userCreateRequest) {
        var user = userService.register(userCreateRequest);
        return new JwtAuthenticationResponse(jwtService.generateToken(user));
    }


    @Override
    public JwtAuthenticationResponse SignIn(UserCreateRequest userCreateRequest) {
        var user = userRepository.findByLogin(userCreateRequest.getLogin());
        var authToken =new UsernamePasswordAuthenticationToken(
                userCreateRequest.getLogin(),
                userCreateRequest.getPassword(),
                user.getAuthorities()
        );
        authenticationManager.authenticate(authToken);
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        context.setAuthentication(authToken);
        SecurityContextHolder.setContext(context);
        String jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);


    }
}
