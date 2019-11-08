package cn.cnm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lele
 * @version 1.0
 * @Description 新建一个Entity类对应数据库中的表
 * @Email 414955507@qq.com
 * @date 2019/11/6 14:21
 */
@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
public class Flower implements Serializable {
    public static final long serialVersionUID = 1234L;

    private int id;
    private String name;
    private double price;
    private String production;
}
