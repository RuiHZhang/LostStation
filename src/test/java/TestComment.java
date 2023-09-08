import com.zrh.dao.CommentDao;
import com.zrh.pojo.Comment;
import com.zrh.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestComment {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void testGetCommentsByLostId(){
        List<Comment> list = commentDao.getCommentsByLostId(2);
        for (Comment c : list) {
            System.out.println(c);
        }
    }
}
