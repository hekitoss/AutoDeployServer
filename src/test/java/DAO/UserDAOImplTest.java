package DAO;

import Entity.UsersEntity;
import Factory.HibernateSessionFactoryUtil;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;


public class UserDAOImplTest extends TestCase {

    private UserDAOImpl userDAO = mock(UserDAOImpl.class);
    private SessionFactory sessionFactory;
    private Session session = mock(Session.class);

    @Before
    public void init(){
        sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();
        session = sessionFactory.openSession();
        when(userDAO.findAll()).thenReturn(new ArrayList<UsersEntity>());
        //doReturn("a").when(userDAO.findAll()); здесь возвращается не правильный тип
    }

    @After
    public void closeSession(){
        session.close();
    }

    @Test
    public void testSave() {
        UsersEntity usersEntity = mock(UsersEntity.class);
        userDAO.save(usersEntity);
        Mockito.verify(userDAO, Mockito.times(1)).save(usersEntity);
    }

    @Test
    public void testFindAll(){
        assertEquals(userDAO.findAll(), new ArrayList<UsersEntity>());
    }
}