package it.giachin.theaters.firenze.service;

import it.giachin.theaters.firenze.dto.response.UserRes;
import it.giachin.theaters.firenze.exception.UserNotFoundException;
import it.giachin.theaters.firenze.model.User;
import it.giachin.theaters.firenze.repository.UserRepository;
import it.giachin.theaters.firenze.service.IService.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(long id, User updateUser) throws UserNotFoundException{

        var user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setEmail(updateUser.getEmail());
        return userRepository.save(user);
    }


    @Override
    public User deleteUser(long userId) {
        return null;
    }

    @Override
    public UserRes searchUserById(long id) {
        return modelMapper.map(userRepository.findById(id), UserRes.class);
    }




}
