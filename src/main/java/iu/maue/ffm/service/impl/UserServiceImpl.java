package iu.maue.ffm.service.impl;

import iu.maue.ffm.dto.UserCreateDTO;
import iu.maue.ffm.dto.UserDTO;
import iu.maue.ffm.entity.User;
import iu.maue.ffm.exception.ExceptionEnum;
import iu.maue.ffm.exception.BizException;
import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.repository.UserRepository;
import iu.maue.ffm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> list() {
        return userRepository.findAll()
                .stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO create(UserCreateDTO userCreateDTO) {
        checkUsername(userCreateDTO.getUsername());
        User user = userMapper.createEntity(userCreateDTO);
        user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            throw new BizException(ExceptionEnum.USER_NOT_FOUND);
        }
        return optionalUser.get();
    }

    /**
     * 校验用户名是否存在
     *
     * @param username 用户名
     */
    private void checkUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            throw new BizException(ExceptionEnum.USER_NAME_EXISTS);
        }
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
