import com.zrh.dao.FindDao;
import com.zrh.dao.LostDao;
import com.zrh.pojo.Find;
import com.zrh.pojo.Lost;
import com.zrh.service.FindService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestFind {
    @Autowired
    private FindDao findDao;
    @Test
    public void testGetAllFinds(){
        List<Find> list = findDao.getAllFinds();
        for (Find find : list) {
            System.out.println(find);
        }
    }
}
