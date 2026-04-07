package com.mandip.student_course_management.security;

import com.mandip.student_course_management.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    //we have to store scretkey in application properties cause if we define here then anyone can get it
    //@Value can automatic take value of secretkey from application properties
    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    //convert our secretkey to hmacShaKey
    //it is header
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    //it is payload using User information
    public String generateAccessToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getId().toString())
                .issuedAt(new Date())   //takes current date
                //Access token should be <short> lived but if you want user can <login> longer time then we can use concept of refresh token
                .expiration(new Date(System.currentTimeMillis() + 1000*60*10)) //expiry at current time + 10minute
                .signWith(getSecretKey()) // we attached secret key
                .compact();
    }

    //get username from token
    public String getUsernameFromToken(String token) {

        //it return claims to we so made object of Claims
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        //and then fetch getsubject which is username which is string so return it
        return claims.getSubject();
    }
}
