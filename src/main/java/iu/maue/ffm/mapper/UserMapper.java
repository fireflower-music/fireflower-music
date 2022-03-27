package iu.maue.ffm.mapper;

import iu.maue.ffm.pojo.request.UserCreateRequest;
import iu.maue.ffm.pojo.dto.UserDTO;
import iu.maue.ffm.entity.User;
import iu.maue.ffm.pojo.request.UserUpdateRequest;
import iu.maue.ffm.pojo.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    UserVO toVO(UserDTO userDTO);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
