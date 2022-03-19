package iu.maue.ffm.service.impl;

import iu.maue.ffm.dto.UserDTO;
import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.repository.UserRepository;
import iu.maue.ffm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;


    @Override
    public List<UserDTO> list() {
        return userRepository.findAll()
                .stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
