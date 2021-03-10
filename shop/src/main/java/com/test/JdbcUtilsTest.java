package com.test;

import com.shop.utils.JdbcUtils;
import org.junit.jupiter.api.Test;


import java.sql.Connection;

/**
 * @author WuLiangHang
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection con = JdbcUtils.getConnection();
            System.out.println(con);
            JdbcUtils.close(con);
            System.out.println();
        }
    }
}
