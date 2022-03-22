package iu.maue.ffm.mapper;

import iu.maue.ffm.pojo.dto.UserCreateDTO;
import iu.maue.ffm.pojo.dto.UserDTO;
import iu.maue.ffm.entity.User;
import iu.maue.ffm.pojo.vo.UserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    UserVO toVO(UserDTO userDTO);

    User createEntity(UserCreateDTO userCreateDTO);
}
