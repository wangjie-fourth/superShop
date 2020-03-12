create table USER(
    ID         bigint primary key auto_increment,
    NAME       varchar(100),
    TEL        varchar(40) unique ,
    AVATAR_URL varchar(1024),
    CREATED_AT timestamp default current_timestamp,
    UPDATED_AT timestamp default current_timestamp on update current_timestamp
);
