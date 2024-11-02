package com.neo.dsapathway.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neo.dsapathway.dto.CreateUserRequest;
import com.neo.dsapathway.model.LeetcodeUser;
import com.neo.dsapathway.model.Users;
import com.neo.dsapathway.repository.UserRepository;
import com.neo.dsapathway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    For leetcode user info
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    UserRepository userRepository;

    @Override
    public Users createUser(CreateUserRequest createUserRequest) {
        Users users = createUserRequest.toUser();
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        List<Users> usersList = userRepository.findAll();
        return usersList;
    }

    @Override
    public LeetcodeUser getLeetcodeUser(String userId) throws JsonProcessingException {
        String url = "https://leetcode.com/graphql";
        String query = "{\"query\":\"{ matchedUser(username: \\\"" + userId + "\\\") { username submitStats: submitStatsGlobal { acSubmissionNum { difficulty count submissions } } } }\"}";
        ResponseEntity<String> response = restTemplate.postForEntity(url, query, String.class);
        return objectMapper.readValue(response.getBody(), LeetcodeUser.class);
    }
}
