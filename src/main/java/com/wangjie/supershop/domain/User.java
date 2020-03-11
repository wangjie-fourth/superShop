package com.wangjie.supershop.domain;

import lombok.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author 25127
 * @Date 2020/3/10 16:39
 * @Email jie.wang13@hand-china.com
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String tel;
    private String avatarUrl;
    private Date createdAt;
    private Date updatedAt;
}
