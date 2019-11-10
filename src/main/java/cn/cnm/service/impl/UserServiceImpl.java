package cn.cnm.service.impl;

import cn.cnm.mapper.UserMapper;
import cn.cnm.pojo.User;
import cn.cnm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/10 13:41
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User getOne(User user) {
        return userMapper.selectOne(user);
    }
}
