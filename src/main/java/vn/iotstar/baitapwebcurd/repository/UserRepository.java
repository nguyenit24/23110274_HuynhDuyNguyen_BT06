package vn.iotstar.baitapwebcurd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.baitapwebcurd.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNameAndPassWord(String userName, String passWord);
    User findByUserName(String userName);
}
