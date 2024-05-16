package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenResponse {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String generateToken(String username) throws JwtException {
        return Jwts.builder()
                .setSubject(username)
                .signWith(key)
                .compact();
    }

    public static String getUsernameFromToken(String token) throws ExpiredJwtException, JwtException {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}