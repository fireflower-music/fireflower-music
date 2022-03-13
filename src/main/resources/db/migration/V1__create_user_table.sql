create table user
(
    id       varchar(32) not null primary key comment '用户ID',
    username varchar(64) not null comment '用户名',
    password varchar(64) not null comment '登录密码',
    gender   varchar(10) null comment '性别',
    email    varchar(255) null
)