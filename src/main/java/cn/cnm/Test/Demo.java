package cn.cnm.Test;

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
 * @Description MyBatis的一个Demo
 * @Email 414955507@qq.com
 * @date 2019/11/6 14:26
 */
public class Demo {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            // 字符流基类， 读取 MyBatis 主配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            // 使用构建者模式（名称带 build）简化对象实例化过程
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            // 使用工厂模式（名称带 Factory）  生产 SqlSession
            SqlSession session = factory.openSession();
            // 开始调用 具体方法看什么操作和什么返回类型， 参数则是 namespace+id（类似于全路径+方法名）
            List<Flower> list = session.selectList("cn.cnm.mapper.FlowerMapper.selectAll");
            list.stream().forEach(System.out::println);
            // 关闭连接， 不然一直处于连接状态
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
