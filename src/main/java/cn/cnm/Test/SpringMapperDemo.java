package cn.cnm.Test;

import cn.cnm.pojo.User;
import cn.cnm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/8 17:13
 */
public class SpringMapperDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        // 直接获取Mapper的接口即可
        UserService userService = applicationContext.getBean("userService", UserService.class);
        // 创建一个封装了查询条件的实体类对象， 实体类的非null属性就是条件
        User selectUser = new User(1, "zhangsan", null, null, null);
        User resultUser = userService.getOne(selectUser);
        System.out.println(resultUser);
    }
}
