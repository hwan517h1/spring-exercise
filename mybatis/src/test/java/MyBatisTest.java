import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContext.xml"})
public class MyBatisTest {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSqlSessionFactory() {
        System.out.println(sqlSessionFactory);
    }

    @Test
    public void testSqlSession() throws Exception {
        System.out.println(sqlSessionFactory.openSession());
    }
}
