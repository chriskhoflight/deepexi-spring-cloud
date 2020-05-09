package com.deepexi.repo;


import com.deepexi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    @Autowired
    private UserMapper mapper;
}
