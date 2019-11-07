package cn.cnm.mapper;

import cn.cnm.pojo.Flower;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author lele
 * @version 1.0
 * @Description 基于注解方式编程， 不需要SQL映射文件（XML）
 * @Email 414955507@qq.com
 * @date 2019/11/7 10:08
 */
public interface FlowerAnnotationMapper {
    @Select("select * from flower")
    List<Flower> getFlower();
}
