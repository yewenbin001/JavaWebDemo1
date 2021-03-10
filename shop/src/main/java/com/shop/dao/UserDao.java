package com.shop.dao;

import com.shop.bean.User;

/**
 * @author WuLiangHang
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null 说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    public int addUser(User user);
}
