package DAO;

import Entity.UsersEntity;
import Factory.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl userDAO;

    private final SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    private UserDAOImpl() {
    }

    public static UserDAOImpl getInstance() {
        UserDAOImpl localUserDAO = userDAO;
        if (localUserDAO == null) {
            synchronized (UserDAOImpl.class) {
                localUserDAO = userDAO;
                if (localUserDAO == null) {
                    localUserDAO = new UserDAOImpl();
                    userDAO = localUserDAO;
                }
            }
        }
        return localUserDAO;
    }



    @Override
    public void save(UsersEntity user) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public void update(UsersEntity user) {
        try (Session session = this.sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void delete(UsersEntity user) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }

    public void delete(int id) {
        try (Session session = this.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            UsersEntity user = session.get(UsersEntity.class, id);
            session.delete(user);
            transaction.commit();
        }
    }


    @Override
    public List<UsersEntity> findAll() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from UsersEntity ", UsersEntity.class).list();
        }
    }
}
