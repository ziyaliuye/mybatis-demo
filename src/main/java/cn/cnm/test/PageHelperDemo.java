package cn.cnm.test;

import cn.cnm.mapper.AirportMapper;
import cn.cnm.pojo.Airport;
import cn.cnm.pojo.AirportExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Description 分页插件PageHelper的使用示例
 * @Email 414955507@qq.com
 * @date 2019/11/7 10:10
 */
public class PageHelperDemo {
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
            // 不添加条件即为查询所有记录
            AirportExample airportExample = new AirportExample();

            /* 使用PageHelper的静态方法可以设置分页信息并返回状态， 第一个参数：页数， 第二个参数：多少记录为一页 */
            Page page = PageHelper.startPage(2, 5);

            // 开始调用实例的方法， MyBatis会自动寻找对应的XML文件中的SQL并执行
            List<Airport> list = airportMapper.selectByExample(airportExample);
            list.forEach(System.out::println);

            /* 使用返回的分页实例可以获取各种分页信息 */
            System.out.println("当前页码：" + page.getPageNum());
            System.out.println("总记录数：" + page.getTotal());
            System.out.println("每页的记录书：" + page.getPageSize());
            System.out.println("总页码：" + page.getPages());

            /* 更强大的PageInfo可以将结果进行包装， 返回更全面的分页信息， 包括是否有下一页等等 */
            PageInfo pageInfo = new PageInfo(list);
            System.out.println("是否有下一页：" + pageInfo.isHasNextPage());
            System.out.println("当前页码是否为最后一页：" + pageInfo.isIsLastPage());

            /* PageInfo两个参数构造器， 第二个参数为导航， 可以设置连续返回多少页 */
            PageInfo pageInfoNavigation = new PageInfo(list, 2);
            // 获取连续显示的页码, 用于前台展示， 类似于贴吧的分页导航， 可以快速切换分页
            System.out.println("连续分页页码：");
            int[] pageNums = pageInfoNavigation.getNavigatepageNums();
            for (int num : pageNums) {
                System.out.println(num);
            }
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
