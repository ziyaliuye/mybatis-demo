package cn.cnm.test;

import cn.cnm.mapper.FlowerMapper;
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
 * @date 2019/11/6 17:20
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            // 字符流基类， 读取 MyBatis 主配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用构建者模式（名称带 build）简化对象实例化过程
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 使用工厂模式（名称带 Factory）  生产 SqlSession
            SqlSession session = factory.openSession();

            // 获取接口的实现类, 由MyBatis自动产生代理对象
            FlowerMapper flowerMapper = session.getMapper(FlowerMapper.class);
            // 开始调用实例的方法， MyBatis会自动寻找对应的XML文件中的SQL并执行
            List<Flower> list = flowerMapper.selectAll();
            list.forEach(System.out::println);
            // 关闭连接， 不然一直处于连接状态
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
