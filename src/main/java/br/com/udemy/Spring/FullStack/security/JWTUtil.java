package br.com.udemy.Spring.FullStack.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JWTUtil {

    // Atributos para gerar o token
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public boolean tokenValid(String token){
        Claims claims = getClaims(token);
        if (claims!= null){
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if (username != null && expirationDate != null && now.before(expirationDate)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private Claims getClaims(String token) {
        try{
            return Jwts.parser().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
        } catch (Exception e){
            return null;
        }

    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims!= null) {
            return claims.getSubject();
        } else {
            return null;
        }
    }
}
