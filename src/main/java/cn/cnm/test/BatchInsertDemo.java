package cn.cnm.test;

import cn.cnm.mapper.PeopleMapper;
import cn.cnm.pojo.People;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/7 10:10
 */
public class BatchInsertDemo {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            // 字符流基类， 读取 MyBatis 主配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用构建者模式（名称带 build）简化对象实例化过程
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            /* 获取sqlSession时需要指定为批量操作， MyBatis会为这些操作做一系列的优化 */
            SqlSession session = factory.openSession(ExecutorType.BATCH);

            PeopleMapper peopleMapper = session.getMapper(PeopleMapper.class);

            // 插入10000条记录
            for (int i = 100; i < 10100; i++) {
                peopleMapper.insert(new People(i, UUID.randomUUID().toString().substring(0, 6), 18, i + 1));
            }

            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
