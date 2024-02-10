package com.project.ecommerce.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    // jwtSecret's placeholder. Can get a secret string form AWS Secret manager.
    private String jwtSecret = "a".repeat(152);

    private int jwtExpirationMs = 1234567;

    private SecretKey key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateJwtToken(Authentication authentication){
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String username = authentication.getName();

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
     }

    public boolean validateToken(String token){
        try{
            Jwts.parser().verifyWith(key()).build().parseSignedClaims(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public String getUserNameFromJwtToken(String token){
        String username = Jwts.parser().setSigningKey(key()).build().parseSignedClaims(token).getPayload().getSubject();
        return username;

    }

}
