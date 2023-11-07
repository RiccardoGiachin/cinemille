package it.giachin.theaters.firenze.service;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mysql.cj.exceptions.PasswordExpiredException;
import it.giachin.theaters.firenze.dto.request.LoginReq;
import it.giachin.theaters.firenze.dto.request.SignupReq;
import it.giachin.theaters.firenze.dto.response.SignUpRes;
import it.giachin.theaters.firenze.exception.UserNotFoundException;
import it.giachin.theaters.firenze.model.User;
import it.giachin.theaters.firenze.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Date;

@Service
@Log4j2
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Value("${authentication.secret.key}")
    private String secretKey;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public SignUpRes authenticate(SignupReq credentialsDto) throws UserNotFoundException {
        var user = userRepository.findByEmail(credentialsDto.getEmail());
        if(user.isEmpty())
            throw new UserNotFoundException();
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap(credentialsDto.getPassword()));
        if (!passwordEncoder.matches(user.get().getPassword(), encodedMasterPassword)) {
            throw new RuntimeException("Invalid password");
        }
        return SignUpRes.builder().name(user.get().getName()).build();

    }

    public SignUpRes findByLogin(String email) throws UserNotFoundException {
        log.log(Level.INFO, "Sto recuperando lo user per Email " + email);

        var user = userRepository.findByEmail(email);
        if(user.isEmpty())
            throw new UserNotFoundException();
        return SignUpRes.builder().name(user.get().getName()).build();
    }
    public SignUpRes signUp(SignupReq request) {
            request.setPassword(passwordEncoder.encode(request.getPassword()));
            var user = userRepository.save(convertDtoToEntity(request));
            return SignUpRes.builder()
                    .name(user.getEmail())
                    .token(createToken(request.getEmail())).build();
    }

    public SignUpRes signIn(LoginReq request) {
        try{
            var pwd = passwordEncoder.encode(request.getPassword());
            var user = userRepository.findByEmail(request.getEmail());
            if(user.isEmpty()){
                throw new UserNotFoundException();
            }
            if(!user.get().getPassword().equals(pwd)){
                throw new PasswordExpiredException();
            }
            return SignUpRes.builder().name(user.get().getEmail()).token(createToken(request.getEmail())).build();

        }catch(Exception ex){
            var i = 0;
        }
        return null;
    }


    public String createToken(String email) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(email)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }
    private User convertDtoToEntity(SignupReq req){
        return modelMapper.map(req, User.class);
    }

}