package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

/**
 * @author WuLiangHang
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     * 按用户名查询用户
     * @param username
     * @return
     */
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT `id`, `username`, `password`, `email` FROM T_user WHERE `username` = ?";
        return super.queryForOne(User.class, sql, username);
    }

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    @Override
    public int  addUser(User user) {
        String sql = "INSERT INTO T_user(username,password,email) VALUES (?,?,?)";
        Object[] params = {user.getUsername(),user.getPassword(),user.getEmail()};
        return super.update(sql,params);
    }


}
