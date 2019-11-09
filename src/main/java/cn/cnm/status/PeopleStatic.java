package cn.cnm.status;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author lele
 * @version 1.0
 * @Description
 * @Email 414955507@qq.com
 * @date 2019/11/9 16:49
 */
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
public enum PeopleStatic {
    LOGIN(100, "用户登录"), LOGOUT(200, "用户退出"), INVALID(300, "失效用户");

    private Integer staticCode;
    private String message;

    private PeopleStatic(Integer staticCode, String message) {
        this.staticCode = staticCode;
        this.message = message;
    }

    public Integer getStaticCode() {
        return staticCode;
    }

    public void setStaticCode(Integer staticCode) {
        this.staticCode = staticCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // 根据staticCode返回PeopleStatic（从数据库查到staticCode时需要返回对应的PeopleStatic）
    public static PeopleStatic getMessage(Integer staticCode) {
        switch (staticCode) {
            case 100:
                return LOGIN;
            case 200:
                return LOGOUT;
            default:
                return INVALID;
        }
    }
}
