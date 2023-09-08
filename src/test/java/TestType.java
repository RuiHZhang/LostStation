import com.zrh.dao.TypeDao;
import com.zrh.pojo.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestType {
    @Autowired
    private TypeDao typeDao;

    @Test
    public void testGetAllTypes(){
        List<Type> types = typeDao.getAllTypes();
        for (Type type : types) {
            System.out.println(type);
        }
    }

}
