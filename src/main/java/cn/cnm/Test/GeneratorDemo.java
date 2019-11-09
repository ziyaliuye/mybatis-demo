package cn.cnm.Test;

import cn.cnm.mapper.FlowerAnnotationMapper;
import cn.cnm.mapper.PeopleMapper;
import cn.cnm.pojo.Flower;
import cn.cnm.pojo.People;
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
 * @Description 测试通过MBG自动生成代码是否可用
 * @Email 414955507@qq.com
 * @date 2019/11/9 12:36
 */
public class GeneratorDemo {
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
            PeopleMapper peopleMapper = session.getMapper(PeopleMapper.class);
            // 开始调用实例的方法， MyBatis会自动寻找对应的XML文件中的SQL并执行
            People people = peopleMapper.selectByPrimaryKey(2);
            System.out.println(people);
            // 关闭连接， 不然一直处于连接状态
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
