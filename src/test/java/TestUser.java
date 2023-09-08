import com.zrh.dao.LocationDao;
import com.zrh.dao.UserDao;
import com.zrh.pojo.Location;
import com.zrh.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestUser {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LocationDao locationDao;

    @Test
    public void testgetUser(){
        User user = userDao.login("张三", "zhangsan");
        System.out.println(user);
    }

    @Test
    public void testGetAllLocations(){
        List<Location> list = locationDao.getAllLocations();
        for (Location l : list) {
            System.out.println(l);
        }
    }

    @Test
    public void testGetAllUserName(){
        List<String> userNames = userDao.getAllUserName();
        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}
