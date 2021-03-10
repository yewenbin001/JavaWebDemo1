package com.shop.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author WuLiangHang
 */
public class JdbcUtils {
    //DruidDataSource监控数据库连接池的类
    private static DruidDataSource dataSource;

    static {
        try {
            //读取jdbc.properties属性配置文件
            Properties properties = new Properties();
            //JdbcUtils.class.getClassLoader()获取JdbcUtils的类加载器
            //getResourceAsStream默认则是从ClassPath根下获取，path不能以’/'开头，最终是由ClassLoader获取资源。
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池 createdatasource方法获取连接池对象
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null 说明获取连接失败 有值就是获取连接成功
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭连接 放回数据库连接池
     *
     * @param con
     */
    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
