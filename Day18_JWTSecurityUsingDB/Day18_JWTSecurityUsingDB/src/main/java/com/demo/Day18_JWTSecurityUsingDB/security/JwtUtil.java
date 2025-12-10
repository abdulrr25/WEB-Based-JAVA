package com.demo.Day18_JWTSecurityUsingDB.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET = "MyStrongJwtSecretKey6503";
    private final static SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    public SecretKey getKey() {
        return KEY;
    }

    public String getSecret() {
        return SECRET;
    }
    
    private static final long EXPIRATION = 2 * 60 * 60 * 1000; 

	
	public static String generateToken(UserDetails user) {
		
		return Jwts.builder()
				.subject(user.getUsername())
				.claim("role","Role_ADMIN")
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY)
				.compact();
	}
	public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    	System.out.println("in extractClaims");
        
    	Claims claims = Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String token, UserDetails user) {
        return extractUsername(token).equals(user.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

}
