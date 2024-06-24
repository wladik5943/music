package by.tms.music.security.service;

import by.tms.music.token.JwtAuthenticationResponse;
import by.tms.music.user.model.UserCreateRequest;

public interface SignService {
    public JwtAuthenticationResponse signIn(UserCreateRequest userCreateRequest);
    public JwtAuthenticationResponse signUp(UserCreateRequest userCreateRequest);

}
