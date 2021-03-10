package com.demo.bean;

import java.util.Date;
import java.util.Objects;

/**
 * @author ：小兵
 * @date ：2021-03-07 11:39
 * @Description:
 */
public class User {
    private String username;
    private String password;
    private Date lastLoginDate;
    private Integer loginCount;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Date lastLoginDate, Integer loginCount) {
        this.username = username;
        this.password = password;
        this.lastLoginDate = lastLoginDate;
        this.loginCount = loginCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginDate=" + lastLoginDate +
                ", loginCount=" + loginCount +
                '}';
    }
}
