import DAO.UserDAOImpl;
import Entity.UsersEntity;

import java.util.List;

public class UserService {
    private UserDAOImpl usersDao = UserDAOImpl.getInstance();

    public UserService() {
    }

    public void saveUser(UsersEntity user) {
        usersDao.save(user);
    }

    public void deleteUser(UsersEntity user) {
        usersDao.delete(user);
    }

    public void deleteUser(int id){
        usersDao.delete(id);
    }

    public void updateUser(UsersEntity user) {
        usersDao.update(user);
    }

    public List<UsersEntity> findAllUsers() {
        return usersDao.findAll();
    }


}
