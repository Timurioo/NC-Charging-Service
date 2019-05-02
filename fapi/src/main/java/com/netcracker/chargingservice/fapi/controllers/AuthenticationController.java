package com.netcracker.chargingservice.fapi.controllers;

import com.netcracker.chargingservice.fapi.models.*;
import com.netcracker.chargingservice.fapi.security.TokenProvider;
import com.netcracker.chargingservice.fapi.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    UserProfileService userProfileService;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @GetMapping("/current")
    public ResponseEntity<UserProfile> authUser(Principal userInfo) {
        RegisterUserConverterToUserProfile converter = new RegisterUserConverterToUserProfile();
        RegisterUser user = userProfileService.findByEmail(userInfo.getName());
        if(user != null) {
            return ResponseEntity.ok(converter.convert(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
