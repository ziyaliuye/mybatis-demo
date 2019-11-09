package cn.cnm.Test;

import cn.cnm.mapper.AirportMapper;
import cn.cnm.pojo.Airport;
import cn.cnm.pojo.AirportExample;
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
            AirportMapper airportMapper = session.getMapper(AirportMapper.class);
            // 除了生成简单的CRUD的实体外， MyBatis还额外生成了强大的查询对象xxxExample（QBC查询）
            AirportExample airportExample = new AirportExample();

            // 获取实例的Criteria属性， 准备设置条件
            /* 注意：一个Criteria属性可以拼接多个条件， 条件之间都是and */
            AirportExample.Criteria criteria1 = airportExample.createCriteria();
            // Criteria：设置查询条件
            criteria1.andIdBetween(1, 2);
            criteria1.andCitynameLike("%长沙%");
            /* 一个Example可以多个Criteria属性， 调用Example的or方法后可以将其设置为or条件 */
            AirportExample.Criteria criteria2 = airportExample.createCriteria();
            criteria2.andCitynameLike("%北京%");
            /* 将criteria2设置为or条件 */
            airportExample.or(criteria2);

            // 将Example实例传入Mapper中， 开始调用selectByExample()查询
            List<Airport> list = airportMapper.selectByExample(airportExample);
            list.forEach(System.out::println);
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
