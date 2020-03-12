package com.wangjie.supershop.domain;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.*;

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
@SuppressFBWarnings("EI_EXPOSE_REP")
public class User {
    private Long id;
    private String name;
    private String tel;
    private String avatarUrl;
    private Date createdAt;
    private Date updatedAt;
}
