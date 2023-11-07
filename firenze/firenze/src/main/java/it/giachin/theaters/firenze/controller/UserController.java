package it.giachin.theaters.firenze.controller;

import it.giachin.theaters.firenze.dto.request.LoginReq;
import it.giachin.theaters.firenze.dto.request.SignupReq;
import it.giachin.theaters.firenze.dto.response.SignUpRes;
import it.giachin.theaters.firenze.dto.response.UserRes;
import it.giachin.theaters.firenze.model.User;
import it.giachin.theaters.firenze.service.AuthenticationService;
import it.giachin.theaters.firenze.service.IService.IUserService;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/v1")
@Log4j2
public class UserController
{
    @Autowired
    AuthenticationService authService;
    @Autowired
    IUserService userService;

    @PostMapping("/v1/signup")
    public ResponseEntity<SignUpRes> signUp(@RequestBody SignupReq request){
        try{
            return ResponseEntity.ok().body(authService.signUp(request));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping("/v1/user/{id}")
    public ResponseEntity<UserRes> searchUser(@PathVariable("id") long id){
        try{
            return ResponseEntity.ok().body(userService.searchUserById(id));
        }catch (Exception ex) {
            log.log(Level.ERROR, ex);
            return ResponseEntity.internalServerError().body(null);
        }
    }


}
