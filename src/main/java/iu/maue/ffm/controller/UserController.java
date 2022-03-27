package iu.maue.ffm.controller;

import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.pojo.request.UserCreateRequest;
import iu.maue.ffm.pojo.request.UserUpdateRequest;
import iu.maue.ffm.pojo.vo.UserVO;
import iu.maue.ffm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    UserMapper userMapper;


    @GetMapping("")
    Page<UserVO> search(@PageableDefault(sort = {"createTime"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.search(pageable).map(userMapper::toVO);
    }

    @GetMapping("/{id}")
    UserVO getOneUser(@PathVariable String id) {
        return userMapper.toVO(userService.getOneById(id));
    }

    @PostMapping("")
    UserVO create(
            @Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVO(userService.create(userCreateRequest));
    }

    @PutMapping("/{id}")
    UserVO update(@PathVariable String id, @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVO(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
