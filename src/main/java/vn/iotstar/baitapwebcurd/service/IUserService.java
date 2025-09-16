package vn.iotstar.baitapwebcurd.service;

import vn.iotstar.baitapwebcurd.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    User findByUserName(String userName);
    User findByUserNameAndPassWord(String userName, String passWord);
    <S extends User> S save(S entity);
    void deleteById(Integer id);
    public User findByEmail(String email);
}