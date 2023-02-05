package me.airlobang.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import me.airlobang.models.User;
import me.airlobang.services.UserService;

@RestController()
@RequestMapping(path = "api/v1/user")
@Api(value = "User Controller", description = "Operations pertaining to User Model")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @ApiOperation(value = "Get a specific User given their Email")
    @GetMapping(path="/{email}")
    public User getUserByUsername(@PathVariable("email") String email) {
        return UserService.getUserByEmail(email);
    }
    
    @ApiOperation(value = "Get all registered Users")
    @GetMapping
    public List<User> getAllUsers() {
        return UserService.findAll();
    }
    
}
