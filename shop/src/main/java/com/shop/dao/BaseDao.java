package com.shop.dao;

import com.shop.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 设计目标：拥有基本的增删改查方法
 * 必须要让DaoImpl类继承
 *
 * @author WuLiangHang
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法 用来执行DML:增删改
     *
     * @param sql
     * @param args
     * @return 返回受影响的行数 如果-1 说明执行失败
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回单格的sql语句
     *
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
