package com.codingshuttle.projects.lovable_clone.controller;


import com.codingshuttle.projects.lovable_clone.dto.auth.*;
import com.codingshuttle.projects.lovable_clone.service.AuthService;
import com.codingshuttle.projects.lovable_clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

private AuthService authService;
private UserService userService;

@PostMapping("/signup")
public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request){
    return ResponseEntity.ok(authService.signup(request));
}
@PostMapping("login")
public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
    return ResponseEntity.ok(authService.login(request));
}
@GetMapping("/me")
public ResponseEntity<UserProfileResonse> getProfile(){
    Long userId= 1L;
    return  ResponseEntity.ok(userService.getProfile(userId));
}

}
