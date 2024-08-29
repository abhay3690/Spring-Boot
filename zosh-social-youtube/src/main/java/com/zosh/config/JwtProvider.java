//package com.zosh.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.Authentication;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//public class JwtProvider {
//    private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
//    public static String generateToken(Authentication auth){
//        String jwt = Jwts.builder()
//                .setIssuer("Codewithabhay").setIssuedAt(new Date())
//                .setExpiration(new Date(new Date().getTime()+86400000)).claim("email", auth.getName()).signWith(key).compact();
//        return  jwt;
//    }
//    public static String getEmailFromJwtToken(String jwt){
////        Bearer Token
//        jwt = jwt.substring(7);
//        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(jwt).getBody();
//        String email = String.valueOf(claims.get("email"));
//        return email;
//    }
// }
package com.zosh.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {

    private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());

    public static String generateToken(Authentication auth) {
        return Jwts.builder()
                .setIssuer("Codewithabhay")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // 24 hours
                .claim("email", auth.getName())
                .signWith(key)
                .compact();
    }

    public static String getEmailFromJwtToken(String jwt) {
        // Check if the token starts with "Bearer "
        if (jwt != null && jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        } else {
            throw new IllegalArgumentException("Invalid JWT token format.");
        }

        // Parse the signed JWT token (JWS)
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return claims.get("email", String.class);
    }
}
