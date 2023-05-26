package br.com.flexpag.payments.service;

import br.com.flexpag.payments.model.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String createToken(User user) {

        return JWT.create()
                .withIssuer("Payments API")
                .withSubject(user.getUsername())
                .withClaim("id: ", user.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusHours(24)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("5a64d5f1d35sf"));
    }
}
