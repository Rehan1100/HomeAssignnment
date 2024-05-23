package com.example.HomeAssignment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final String USERS_API_URL = "https://gorest.co.in/public/v2/users";
    private final String POSTS_API_URL = "https://gorest.co.in/public/v2/posts";
    private final String COMMENTS_API_URL = "https://gorest.co.in/public/v2/comments";
    private final String ACCESS_TOKEN = "e495820e400c7131e6c272bd9948707b7df082cd8ccd6192eff7bf79298f892d";

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Object> getAllUsers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(ACCESS_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object[]> response = restTemplate.exchange(USERS_API_URL, HttpMethod.GET, entity, Object[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Object> getAllThePost() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(ACCESS_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object[]> response = restTemplate.exchange(POSTS_API_URL, HttpMethod.GET, entity, Object[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public List<Object> getAllTheComments() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(ACCESS_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object[]> response = restTemplate.exchange(COMMENTS_API_URL, HttpMethod.GET, entity, Object[].class);
        return Arrays.asList(response.getBody());
    }
}
