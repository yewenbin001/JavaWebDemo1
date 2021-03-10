package com.shop.service;

import com.shop.bean.User;
import com.shop.dao.impl.UserDaoImpl;

/**
 * @author ：小兵
 * @date ：2021-03-09 20:04
 * @Description:
 */
public class UserService {
    UserDaoImpl userDao=new UserDaoImpl();

    /**
     * 注册验证
     * @param user
     * @return
     */
    public boolean addUser(User user){
        if (userDao.addUser(user)!=-1){
            return true;
        }else {
            return false;
        }
    }

    public User userLogin(User user){
        User reUset=userDao.queryUserByUsername(user.getUsername());
        if (reUset!=null){
            if (user.getPassword().equals(reUset.getPassword())){
                return reUset;
            }
        }
        return null;
    }
}
