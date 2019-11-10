package cn.cnm.test;

import cn.cnm.mapper.FlowerAnnotationMapper;
import cn.cnm.pojo.Flower;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/7 10:10
 */
public class CacheDemo {
    public static void main(String[] args) {
        InputStream inputStream;
        SqlSessionFactory factory = null;
        try {
            // 字符流基类， 读取 MyBatis 主配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用构建者模式（名称带 build）简化对象实例化过程
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 这样写二级缓存是无效的， 因为第二个sqlSession在执行时第一个并没有关闭， 所以缓存是不存在的
        try (SqlSession session1 = factory.openSession(); SqlSession session2 = factory.openSession();) {
            List<Flower> list1 = session1.selectList("cn.cnm.mapper.FlowerMapper.selectAll");
            list1.forEach(System.out::println);
            System.out.println("=========================");

            FlowerAnnotationMapper flowerAnnotationMapper2 = session2.getMapper(FlowerAnnotationMapper.class);
            List<Flower> list2 = session2.selectList("cn.cnm.mapper.FlowerMapper.selectAll");
            list2.forEach(System.out::println);
        }

        try (SqlSession session1 = factory.openSession()) {
            List<Flower> list1 = session1.selectList("cn.cnm.mapper.FlowerMapper.selectAll");
            list1.forEach(System.out::println);
            System.out.println("=========================");
        }
        // 这样第二个sqlSession才能使用缓存， 因为第一个sqlSession已经关闭了
        try (SqlSession session2 = factory.openSession()) {
            List<Flower> list2 = session2.selectList("cn.cnm.mapper.FlowerMapper.selectAll");
            list2.forEach(System.out::println);
        }
    }
}
