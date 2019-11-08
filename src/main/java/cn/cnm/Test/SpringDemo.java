package cn.cnm.Test;

import cn.cnm.mapper.FlowerMapper;
import cn.cnm.pojo.Flower;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/8 17:13
 */
public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        // 直接获取Mapper的接口即可
        FlowerMapper flowerMapper = applicationContext.getBean("flowerMapper", FlowerMapper.class);
        List<Flower> list = flowerMapper.selectAll();
        list.forEach(System.out::println);
    }
}
