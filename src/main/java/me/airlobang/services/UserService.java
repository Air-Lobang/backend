package me.airlobang.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.airlobang.models.User;
import me.airlobang.repositories.UserRepository;
import me.airlobang.exceptions.*;

@Service
public class UserService {
    
    private UserRepository UserRepository;


    @Autowired
    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }
    
    /**
     * Gets User with given email
     * 
     * @param email
     * @return
     */
    public User getUserByEmail(String email) {
        Optional<User> optionalUser = UserRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Email not found");
        }
        return optionalUser.get();
    }

    /**
     * Gets User with given phone number
     * 
     * @param phoneNumber
     * @return
     */
    public User getUserByPhoneNumber(String phoneNumber) {
        Optional<User> optionalUser = UserRepository.findByPhoneNumber(phoneNumber);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Phone number not found");
        }
        return optionalUser.get();
    }

    /**
     * Gets all Users
     * 
     * @return
     */
    public List<User> findAll() {
        return UserRepository.findAll();
    }
}

