package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.UserProfile;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customUserDetailsService")
public class UserProfileServiceImpl implements UserDetailsService, UserProfileService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserProfile findByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        UserProfile user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, UserProfile.class);
        return user;
    }

    @Override
    public List<UserProfile> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserProfile[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", UserProfile[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public UserProfile save(UserProfile user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, UserProfile.class).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = findByLogin(username);
        if (userProfile == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(userProfile.getLogin(),
                userProfile.getPassword(), getAuthority(userProfile));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserProfile userProfile) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getRole()));
        return authorities;
    }

}
