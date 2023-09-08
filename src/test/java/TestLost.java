import com.zrh.dao.LostDao;
import com.zrh.pojo.Lost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestLost {
    @Autowired
    private LostDao lostDao;
    @Test
    public void testGetAllLosts(){
        List<Lost> list = lostDao.getAllLosts();
        for (Lost lost : list) {
            System.out.println(lost);
        }
    }

    @Test
    public void testFile(){
        File file = new File("D:\\桌面文件\\Java千峰相关文件\\java2305\\阶段3\\exercise\\lostStationManage\\src\\main\\webapp\\image\\lost");
        System.out.println(file.exists());
    }

    @Test
    public void testGetLostsByUserId(){
        List<Lost> losts = lostDao.getLostsByUserId(1);
        for (Lost lost : losts) {
            System.out.println(lost);
        }
    }
}
