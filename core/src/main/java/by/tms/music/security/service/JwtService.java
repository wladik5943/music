package by.tms.music.security.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    public String generateToken(UserDetails userDetails) ;
    public String extractUserName(String token);
    public boolean isTokenValid(String token, UserDetails userDetails);
}
