package iu.maue.ffm.repository;

import iu.maue.ffm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findListByUsername(String username);

    User getOneByUsername(String username);
}
