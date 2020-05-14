package com.deepexi.service.manager;


import com.deepexi.service.Builder;
import com.deepexi.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager {
    @Autowired
    private Builder builder;

    public User current(){

        return builder.buildUser(1L);
}


}
