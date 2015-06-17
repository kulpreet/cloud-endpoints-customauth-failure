package com.example.sample.backend;

import com.google.api.server.spi.auth.common.User;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public class SampleAuthenticator implements com.google.api.server.spi.config.Authenticator {

    private static final Logger logger = Logger.getLogger(SampleAuthenticator.class.getName());

    @Override
    public User authenticate(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("Authorization");
        return new User("sampletestid");
    }
}
