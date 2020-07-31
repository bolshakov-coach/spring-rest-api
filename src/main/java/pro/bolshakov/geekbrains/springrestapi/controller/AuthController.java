package pro.bolshakov.geekbrains.springrestapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pro.bolshakov.geekbrains.springrestapi.config.JwtTokenUtil;
import pro.bolshakov.geekbrains.springrestapi.dto.JwtRequest;
import pro.bolshakov.geekbrains.springrestapi.dto.JwtResponse;

import java.util.Collections;

@RestController
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception{
        UserDetails userDetails = new User(authRequest.getUsername(), authRequest.getPassword(), Collections.emptyList());

        String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
}
