package cn.cnm.test;

import cn.cnm.mapper.PeopleMapper;
import cn.cnm.pojo.People;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.UUID;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/8 17:13
 */
public class SpringBatchDemo {
    // 自动注入批量操作的sqlSession, 正式开发中在service层注入
    // @Autowired
    // private SqlSession batchSqlSession;

    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

        // 实际开发中从图哦service注入后直接使用即可， 不用这么麻烦
        SqlSession batchSqlSession = applicationContext.getBean("batchSqlSession", SqlSession.class);

        PeopleMapper peopleMapper = batchSqlSession.getMapper(PeopleMapper.class);

        // 插入10000条记录
        for (int i = 50100; i < 60100; i++) {
            peopleMapper.insert(new People(i, UUID.randomUUID().toString().substring(0, 6), 18, i + 1));
        }

        // batchSqlSession.commit();
        System.out.println("插入完成...");
    }


    public static void main(String[] args) {
        new SpringBatchDemo().test();
    }
}
