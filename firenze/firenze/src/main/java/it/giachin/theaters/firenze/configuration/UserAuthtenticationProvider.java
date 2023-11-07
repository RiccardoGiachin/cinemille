package it.giachin.theaters.firenze.configuration;

import it.giachin.theaters.firenze.dto.request.SignupReq;
import it.giachin.theaters.firenze.dto.response.SignUpRes;
import it.giachin.theaters.firenze.exception.UserNotFoundException;
import it.giachin.theaters.firenze.service.AuthenticationService;
import org.springframework.stereotype.Component;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
@Component
public class UserAuthtenticationProvider {
    @Value("${authentication.secret.key}")
    private String secretKey;

    private final AuthenticationService authenticationService;

    public UserAuthtenticationProvider(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Authentication validateToken(String token) throws UserNotFoundException {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        var user = authenticationService.findByLogin(decoded.getIssuer());

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }
}
