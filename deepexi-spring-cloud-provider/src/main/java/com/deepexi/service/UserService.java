package com.deepexi.service;


import com.deepexi.domain.dto.UserCreateDTO;
import com.deepexi.domain.dto.UserQueryDTO;
import com.deepexi.domain.vo.UserVO;
import com.deepexi.service.entity.User;
import com.deepexi.service.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserManager userManager;

    public Long create(UserCreateDTO dto) {

        return userManager.current().createUser();

    }

    public void delete(long id) {
    }

    public void update(UserCreateDTO dto,Long id) {
    }

    public UserVO getUser(Long id) {
        return new UserVO();
    }

    public List<UserVO> list(UserQueryDTO dto) {
        return new ArrayList<UserVO>();
    }

//    public User findByUserName(String username) {
//        return new User();
//    }

    public String login(String username, String password) {
        return "1";
    }
}
