package cn.cnm.typehandler;

import cn.cnm.status.PeopleStatic;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lele
 * @version 1.0
 * @Description 接口的泛型就是需要处理的枚举类型
 * @Email 414955507@qq.com
 * @date 2019/11/9 16:46
 */
public class MyEnumTypeHandler implements TypeHandler<PeopleStatic> {
    /*  定义当前数据如何保存到数据库中 */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, PeopleStatic peopleStatic, JdbcType jdbcType) throws SQLException {
        // 第一个参数是索引， 照着传入即可
        // 第二个参数就是枚举的对象， 需要通过它获取它只
        preparedStatement.setString(i, peopleStatic.getStaticCode().toString());
    }

    /* 通过数据库列名获取状态码后如何处理 */
    @Override
    public PeopleStatic getResult(ResultSet resultSet, String s) throws SQLException {
        return PeopleStatic.getMessage(resultSet.getInt(s));
    }

    /* 通过数据库索引获取状态码后如何处理 */
    @Override
    public PeopleStatic getResult(ResultSet resultSet, int i) throws SQLException {
        return PeopleStatic.getMessage(resultSet.getInt(i));
    }

    /* 通过数据库存储过程获取获取到状态码时处理 */
    @Override
    public PeopleStatic getResult(CallableStatement callableStatement, int i) throws SQLException {
        return PeopleStatic.getMessage(callableStatement.getInt(i));
    }
}
