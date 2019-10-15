import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:web/WEB-INF/applicationContext.xml"})
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() throws Exception {
        System.out.println(dataSource.getConnection());
    }
}