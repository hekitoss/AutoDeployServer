package DAO;

import Entity.UsersEntity;

import java.util.List;

public interface UserDAO {
    void save(UsersEntity user);
    void update(UsersEntity user);
    void delete(UsersEntity user);
    List<UsersEntity> findAll();
}
