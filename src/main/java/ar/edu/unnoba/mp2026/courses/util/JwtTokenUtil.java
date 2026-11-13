package ar.edu.unnoba.mp2026.courses.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtTokenUtil {

    private static final String SECRET = "mp2026-secret-key";
    private static final Algorithm ALGORITHM = Algorithm.HMAC512(SECRET);
    private static final long EXPIRATION_TIME = 10L * 24 * 60 * 60 * 1000; // 10 días en milisegundos

    public String generateToken(String subject) {
        String token = JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(ALGORITHM);
        return "Bearer " + token;
    }

    public boolean verify(String token) {
        try {
            String cleanToken = token.replace("Bearer ", "");
            JWTVerifier verifier = JWT.require(ALGORITHM).build();
            verifier.verify(cleanToken);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String getSubject(String token) {
        String cleanToken = token.replace("Bearer ", "");
        DecodedJWT decodedJWT = JWT.require(ALGORITHM).build().verify(cleanToken);
        return decodedJWT.getSubject();
    }
}
