package com.wangjie.supershop.mapper;

import com.wangjie.supershop.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:56
 * @Email jie.wang13@hand-china.com
 **/
@Mapper
@Repository
public interface UserMapper {

    void insertUser(User user);

    User getUserByTel(@Param("tel") String tel);
}
