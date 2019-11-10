package cn.cnm.mapper;

import cn.cnm.pojo.User;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author lele
 * @version 1.0
 * @Description 通用Mapper编码步骤二：新建一个继承了继承 Mapper<T>的接口， 泛型即对应的实体类
 * @Email 414955507@qq.com
 * @date 2019/11/10 13:18
 */
public interface UserMapper extends Mapper<User> {
}
