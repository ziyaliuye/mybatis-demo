package cn.cnm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author lele
 * @version 1.0
 * @Description 通用Mapper编码步骤一：新建一个实体类（属性和数据库字段对应）
 * @Email 414955507@qq.com
 * @date 2019/11/10 13:15
 */
@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
@Table(name="user") // 指定对应的表名
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String password_salt;
    private String status;
}
