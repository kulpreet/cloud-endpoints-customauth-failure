package com.example.sample.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;

import java.util.List;

@Api(
        name = "sampleApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.sample.example.com",
                ownerName = "backend.sample.example.com",
                packagePath = ""
        ),
        authenticators = {SampleAuthenticator.class}
//        scopes = {ApiConstants.EMAIL_SCOPE},
//        clientIds = {ApiConstants.WEB_CLIENT_ID, ApiConstants.ANDROID_CLIENT_ID},
//        audiences = {ApiConstants.ANDROID_AUDIENCE}
)

public class UserAccountEndpoint {

    @ApiMethod(name = "getStuff")
    public Entity getStuff(User user) {
        Entity entity = new Entity("Sample");
        entity.setProperty("name", "First");
        return entity;
    }


    @ApiMethod(name = "getStuffOnAuth", path = "authenticated")
    public Entity getStuffOnAuth(User user) {
        Entity entity = new Entity("Sample");
        if (user != null) {
            entity.setProperty("name", "Success");
        } else {
            entity.setProperty("name", "Failed");
        }
        return entity;
    }

}