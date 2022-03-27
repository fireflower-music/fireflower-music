package iu.maue.ffm.service;

import iu.maue.ffm.entity.User;
import iu.maue.ffm.pojo.dto.UserDTO;
import iu.maue.ffm.pojo.request.UserCreateRequest;
import iu.maue.ffm.pojo.request.UserUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    Page<UserDTO> search(Pageable pageable);

    UserDTO getOneById(String id);

    UserDTO create(UserCreateRequest userCreateRequest);

    UserDTO update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    @Override
    User loadUserByUsername(String username);
}
