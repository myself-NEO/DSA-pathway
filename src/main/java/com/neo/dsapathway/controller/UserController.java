package com.neo.dsapathway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neo.dsapathway.dto.CreateUserRequest;
import com.neo.dsapathway.model.LeetcodeUser;
import com.neo.dsapathway.model.Users;
import com.neo.dsapathway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://keshav-jha.netlify.app")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/savenewuser")
    public ResponseEntity<Users> saveNewUser(@RequestBody CreateUserRequest createUserRequest) {
        Users users = userService.createUser(createUserRequest);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> usersList = userService.getAllUser();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }


//    Will call public graphql api of leetcode
    @GetMapping("/getLeetcodeUser")
    public ResponseEntity<LeetcodeUser> getUserDetails(@RequestParam String userId) throws JsonProcessingException {
        LeetcodeUser leetcodeUser = userService.getLeetcodeUser(userId);
        return new ResponseEntity<>(leetcodeUser, HttpStatus.OK);
    }
}
