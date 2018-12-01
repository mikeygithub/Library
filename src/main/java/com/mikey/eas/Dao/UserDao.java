package com.mikey.eas.Dao;


import com.mikey.eas.Pojo.Role;
import com.mikey.eas.Pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/10/23 17:46
 * @Version 1.0
 */
@Component
public interface UserDao {
    public boolean userExist(User user) throws Exception;//检查用户是否已经存在
    public void addNewUser(User user) throws Exception;//添加新用户
    public void deleteUser(String user_identifier) throws Exception;//删除用户
    public void updateUser(User user) throws Exception;//更新用户信息
    public void updateSelfMessage(User user) throws Exception;//更新自己的信息
    public User getUser(String id);//通过学号或者教务编号查询用户
    public List<Role> getUserRoles(User user);//查询用户对应的角色
}
