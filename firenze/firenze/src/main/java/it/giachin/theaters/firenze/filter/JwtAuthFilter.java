package it.giachin.theaters.firenze.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.giachin.theaters.firenze.configuration.UserAuthtenticationProvider;
import it.giachin.theaters.firenze.dto.request.SignupReq;
import it.giachin.theaters.firenze.exception.UserNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Component
public class JwtAuthFilter  extends OncePerRequestFilter {

    @Value("${authentication.secret.key}")
    private String SECRET;

    @Value("${authentication.expiration.date}")
    public long EXPIRATION_TIME;

    private final UserAuthtenticationProvider userAuthenticationProvider;

    public JwtAuthFilter(UserAuthtenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if(header == null){
            SecurityContextHolder.clearContext();
            httpServletResponse.setStatus(401);
            return;
        }

        String[] authElements = header.split(" ");

        if (authElements.length == 2
                && "Bearer".equals(authElements[0])) {
            try {
                SecurityContextHolder.getContext().setAuthentication(
                        userAuthenticationProvider.validateToken(authElements[1]));
            } catch (RuntimeException e) {
                httpServletResponse.setStatus(401);
                httpServletResponse.getWriter().write("Token non valido");
                return;
            }catch (UserNotFoundException ex){
                httpServletResponse.setStatus(401);
                httpServletResponse.getWriter().write("User non valido");
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request){
        String path = request.getRequestURI();
        return "/v1/signup".equals(path);
    }


}
