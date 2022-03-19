package iu.maue.ffm.service;

import iu.maue.ffm.dto.UserCreateDTO;
import iu.maue.ffm.dto.UserDTO;
import iu.maue.ffm.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    List<UserDTO> list();

    UserDTO create(UserCreateDTO userCreateDTO);

    @Override
    User loadUserByUsername(String username);
}
