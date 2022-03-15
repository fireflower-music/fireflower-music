package iu.maue.ffm.repository;

import iu.maue.ffm.entity.User;
import iu.maue.ffm.enums.GenderEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepo;

    @Test
    void save() {

    }

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("lindseyxcdh");
        user.setNickname("lindsey");
        user.setEnabled(true);
        user.setLocked(false);
        user.setPassword("woshitiancai");
        user.setGender(GenderEnum.FEMALE);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());
        userRepo.save(user);

        User user1 = userRepo.getOneByUsername("lindseyxcdh");
        System.out.println(user1);

    }

    @Test
    void testUser() {

    }
}