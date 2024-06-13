package by.tms.music.security.service.impl;

import by.tms.music.entity.User;
import by.tms.music.security.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtServiceImpl implements JwtService {

    private static final String jwtSecret="SGVsbG9Xb3JsZFRlYWNobWVTa2lsbHNBbmRTb21ldGhpbmdFbHNlSUxpa2VKYXZhQW5kSUhvcGVUaGF0WW91TGlrZUphdmFUb28=";

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        if (userDetails instanceof User customUserDetails) {
            claims.put("id", customUserDetails.getId());
            claims.put("login", customUserDetails.getLogin());
            claims.put("role", customUserDetails.getRole());
        }
        return generateToken(claims, userDetails);
    }


    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder().claims(extraClaims).subject(userDetails.getUsername()).
                issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() + 100 * 60 * 24)).
                signWith(getSigningKey()).compact();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
