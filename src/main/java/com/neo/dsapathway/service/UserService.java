package com.neo.dsapathway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neo.dsapathway.dto.CreateUserRequest;
import com.neo.dsapathway.model.LeetcodeUser;
import com.neo.dsapathway.model.Users;

import java.util.List;

public interface UserService {

    Users createUser(CreateUserRequest createUserRequest);

    List<Users> getAllUser();

    LeetcodeUser getLeetcodeUser(String userId) throws JsonProcessingException;
}
