package it.giachin.theaters.firenze.service.IService;

import it.giachin.theaters.firenze.dto.response.UserRes;
import it.giachin.theaters.firenze.exception.UserNotFoundException;
import it.giachin.theaters.firenze.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IUserService {

    Optional<User> getUserByEmail(String email);

    User saveUser(User user);

    User updateUser(long id, User updateUser) throws UserNotFoundException;

    User deleteUser(long userId);

    UserRes searchUserById(long id);
}
