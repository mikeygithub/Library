package com.mikey.eas.Dao.impl;

import com.mikey.eas.Dao.UserDao;
import com.mikey.eas.Mapper.UserMapper;
import com.mikey.eas.Pojo.Role;
import com.mikey.eas.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/10/23 17:46
 * @Version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean userExist(User user) throws Exception {
        return false;
    }

    @Override
    public void addNewUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(String user_identifier) throws Exception {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void updateSelfMessage(User user) throws Exception {

    }

    /**
     * 通过学号或者教务编号查询用户
     * @param id
     * @return
     */
    @Override
    public User getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> getUserRoles(User user) {
        return null;
    }

}
