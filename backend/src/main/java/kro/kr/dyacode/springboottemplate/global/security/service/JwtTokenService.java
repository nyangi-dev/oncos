package kro.kr.dyacode.springboottemplate.global.security.service;

import java.security.Key;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenService {

    private String secret = "thisisthejsonwebtokensecretkeyforuserauthentication";

    Key key = Keys.hmacShaKeyFor(secret.getBytes());

    public String createToken(Long id) {
        return Jwts
                .builder()
                .claim("id", id)
                .signWith(key)
                .compact();
    }

    public Long getId (String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("id", Long.class);
    }

    public boolean validate (String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception ignored) {}

        return false;
    }
}