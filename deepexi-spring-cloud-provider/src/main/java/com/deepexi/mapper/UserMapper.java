package com.deepexi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.deepexi.domain.entity.UserDO;
import com.deepexi.service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    User findByUserName(@Param("username") String username);
}
