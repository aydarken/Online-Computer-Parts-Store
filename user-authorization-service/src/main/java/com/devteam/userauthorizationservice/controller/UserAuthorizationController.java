package com.devteam.userauthorizationservice.controller;

import com.devteam.userauthorizationservice.model.AuthenticationRequest;
import com.devteam.userauthorizationservice.model.AuthenticationResponse;
import com.devteam.userauthorizationservice.service.UserDetailsServiceImpl;
import com.devteam.userauthorizationservice.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authorization")
public class UserAuthorizationController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserDetailsServiceImpl userDetailsService;
    @Autowired private JwtUtil jwtUtil;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthorizationToken(
        @RequestBody AuthenticationRequest authenticationRequest
    ) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect email or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }

}
