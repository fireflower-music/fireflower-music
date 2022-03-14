drop table if exists `user_role`;
drop table if exists `user`;
drop table if exists `role`;

create table `user`
(
    `id`              varchar(32) not null primary key comment '用户ID',
    `username`        varchar(64) not null comment '用户名',
    `password`        varchar(64) not null comment '登录密码',
    `gender`          varchar(10) null comment '性别',
    `nickname`        varchar(64) null comment '用户昵称',
    `locked`          tinyint(1) default 0 not null comment '是否锁定 1-是 0-否',
    `enabled`         tinyint(1) default 1 not null comment '是否可用 1-是 0-否',
    `last_login_ip`   varchar(64) null comment '最后登录ip',
    `last_login_time` datetime(6) null comment '最后登录时间',
    `create_time`     datetime(6) not null comment '创建时间',
    `update_time`     datetime(6) not null comment '更新时间',
    constraint uk_user_username unique (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin comment '用户表';

create table `role`
(
    `id`          varchar(32) not null primary key comment '角色ID',
    `name`        varchar(128) null comment '角色名称',
    `title`       varchar(128) null comment '角色标识',
    `create_time` datetime(6) not null comment '创建时间',
    `update_time` datetime(6) not null comment '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin comment '角色表';

create table `user_role`
(
    `user_id` varchar(32) not null comment '用户ID',
    `role_id` varchar(32) not null comment '角色ID',
    constraint c_user_id foreign key (`user_id`) references user (`id`),
    constraint c_role_id foreign key (`role_id`) references role (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin comment '用户角色表';