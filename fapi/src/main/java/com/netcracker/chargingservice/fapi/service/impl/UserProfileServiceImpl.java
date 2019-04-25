package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.UserProfile;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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
    public UserProfile findByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/email/" + email, UserProfile.class);
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
        return restTemplate.postForEntity(backendServerUrl + "/api/user/signup", user, UserProfile.class).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserProfile userProfile = findByEmail(email);
        if (userProfile == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(userProfile.getEmail(),
                userProfile.getPassword(), getAuthority(userProfile));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserProfile userProfile) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getRole()));
        return authorities;
    }

}
