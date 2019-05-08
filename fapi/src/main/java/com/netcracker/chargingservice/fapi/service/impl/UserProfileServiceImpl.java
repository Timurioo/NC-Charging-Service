package com.netcracker.chargingservice.fapi.service.impl;

import com.netcracker.chargingservice.fapi.models.RegisterUser;
import com.netcracker.chargingservice.fapi.security.SecurityJwtConstants;
import com.netcracker.chargingservice.fapi.security.TokenProvider;
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

    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public RegisterUser findByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/email/" + email, RegisterUser.class);
    }

    @Override
    public RegisterUser findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/id" + id, RegisterUser.class);
    }

    @Override
    public List<RegisterUser> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        RegisterUser[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/user", RegisterUser[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public RegisterUser save(RegisterUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/user/signup", user, RegisterUser.class).getBody();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisterUser registerUser = findByEmail(email);
        if (registerUser == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(registerUser.getEmail(),
                registerUser.getPassword(), getAuthority(registerUser));
    }

    private Set<SimpleGrantedAuthority> getAuthority(RegisterUser registerUser) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + registerUser.getRole().getName().toUpperCase()));
        return authorities;
    }

    @Override
    public String getUsername(String bearerToken) {
        String email = null;
        String authToken = bearerToken.replace(SecurityJwtConstants.TOKEN_PREFIX, "");
        try {
            email = tokenProvider.getUsernameFromToken(authToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return email;
    }
}
