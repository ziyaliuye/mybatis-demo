package cn.cnm.service;

import cn.cnm.pojo.User;

/**
 * @author lele
 * @version 1.0
 * @Description 因为使用了Spring的声明式事务， 所以操作最好写在Service层
 * @Email 414955507@qq.com
 * @date 2019/11/10 13:40
 */
public interface UserService {
    User getOne(User user);
}
