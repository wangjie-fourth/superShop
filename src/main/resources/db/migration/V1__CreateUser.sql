create table USER(
    ID         bigint primary key auto_increment comment '主键id',
    NAME       varchar(100) comment '用户名称',
    TEL        varchar(40) unique comment '电话号码',
    AVATAR_URL varchar(1024) comment '用户头像地址',
    CREATED_AT timestamp default current_timestamp comment '创建时间',
    UPDATED_AT timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
);
