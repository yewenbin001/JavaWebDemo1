package com.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @author WuLiangHang
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername(){
        System.out.println(userDao.queryUserByUsername("admin"));
    }
    @Test
    public void addUser(){
        User user = new User("ywb","123","1580@qq.com");
        int i= userDao.addUser(user);
        System.out.println(i);
    }
}
