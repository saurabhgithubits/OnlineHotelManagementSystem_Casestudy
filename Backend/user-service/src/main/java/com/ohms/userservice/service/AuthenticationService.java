package com.ohms.userservice.service;

import com.ohms.userservice.util.request.SignUpRequest;
import com.ohms.userservice.util.request.SigninRequest;
import com.ohms.userservice.util.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}