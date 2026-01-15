package com.victornext.security.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.victornext.security.entity.User;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenConfig {
    private String secret = "secret"; //logico em app grande coloca nas variaveis de ambiente

    Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(User user){
        return JWT.create()
                .withClaim("userId", user.getId())
                .withExpiresAt(Instant.now().plusSeconds(8000))
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

}
