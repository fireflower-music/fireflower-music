package iu.maue.ffm.controller;

import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.service.UserService;
import iu.maue.ffm.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    UserMapper userMapper;


    @GetMapping("/list")
    List<UserVO> list() {
        return userService.list()
                .stream().map(userMapper::toVO).collect(Collectors.toList());
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
