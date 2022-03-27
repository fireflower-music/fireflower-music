package iu.maue.ffm.service.impl;

import iu.maue.ffm.entity.User;
import iu.maue.ffm.framework.exception.BizException;
import iu.maue.ffm.framework.exception.ExceptionEnum;
import iu.maue.ffm.mapper.UserMapper;
import iu.maue.ffm.pojo.dto.UserDTO;
import iu.maue.ffm.pojo.request.UserCreateRequest;
import iu.maue.ffm.pojo.request.UserUpdateRequest;
import iu.maue.ffm.repository.UserRepository;
import iu.maue.ffm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;


    @Override
    public Page<UserDTO> search(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDTO);
    }

    @Override
    public UserDTO getOneById(String id) {
        // TODO: Rebuild
        User user = userRepository.getOneById(id);
        if (user == null) {
            throw new BizException(ExceptionEnum.USER_NOT_FOUND);
        }
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO create(UserCreateRequest userCreateRequest) {
        checkUsername(userCreateRequest.getUsername());
        User user = userMapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(userCreateRequest.getPassword()));
        user.setNickname(userCreateRequest.getNickname() != null ? userCreateRequest.getNickname() : userCreateRequest.getUsername());
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(String id, UserUpdateRequest userUpdateRequest) {
        // TODO: Rebuild
        User user = userRepository.getOneById(id);
        if (user == null) {
            throw new BizException(ExceptionEnum.USER_NOT_FOUND);
        }
        return userMapper.toDTO(
                userRepository.save(userMapper.updateEntity(user, userUpdateRequest)));
    }

    @Override
    public void delete(String id) {
        // TODO: Rebuild
        User user = userRepository.getOneById(id);
        if (user == null) {
            throw new BizException(ExceptionEnum.USER_NOT_FOUND);
        }
        userRepository.delete(user);
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

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            throw new BizException(ExceptionEnum.USER_NOT_FOUND);
        }
        return optionalUser.get();
    }

    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private void setUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
