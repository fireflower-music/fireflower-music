package iu.maue.ffm.vo;

import iu.maue.ffm.enums.GenderEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Data
public class UserVO {

    private String id;

    private String username;

    private GenderEnum gender;

    private String nickname;

    private List<RoleVO> roleVOS;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;
}
