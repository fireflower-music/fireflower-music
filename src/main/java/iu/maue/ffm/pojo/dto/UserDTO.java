package iu.maue.ffm.pojo.dto;

import iu.maue.ffm.enums.GenderEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserDTO {

    private String id;

    private String username;

    private GenderEnum gender;

    private String nickname;

    private List<RoleDTO> roleDTOS;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
