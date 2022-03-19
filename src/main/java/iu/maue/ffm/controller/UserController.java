package iu.maue.ffm.controller;

import iu.maue.ffm.dto.UserCreateDTO;
import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.service.UserService;
import iu.maue.ffm.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    UserMapper userMapper;


    @GetMapping("")
    List<UserVO> list() {
        return userService.list()
                .stream().map(userMapper::toVO).collect(Collectors.toList());
    }

    @PostMapping("")
    UserVO create(@RequestBody UserCreateDTO userCreateDTO) {
        return userMapper.toVO(userService.create(userCreateDTO));
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
