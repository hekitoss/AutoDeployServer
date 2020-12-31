package Factory;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class HibernateSessionFactoryUtilTest extends TestCase {

    @Test
    public void testGetSessionFactory() {
        Assert.assertEquals(HibernateSessionFactoryUtil.getSessionFactory(),HibernateSessionFactoryUtil.getSessionFactory());
    }
}