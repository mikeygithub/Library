package com.mikey.eas.Service.impl;

import com.mikey.eas.Dao.UserDao;
import com.mikey.eas.Service.UserService;
import com.mikey.eas.Pojo.Role;
import com.mikey.eas.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @date 2018/10/23 17:45
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean userExist(User user) throws Exception {
        return userDao.userExist(user);
    }

    @Override
    public User userLogin(User user) throws Exception {
        return null;
    }

    @Override
    public void addNewUser(User user) throws Exception {
        userDao.addNewUser(user);
    }

    @Override
    public void deleteUser(String user_identifier) throws Exception {
        userDao.deleteUser(user_identifier);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public void updateSelfMessage(User user) throws Exception {
        userDao.updateSelfMessage(user);
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public List<Role> getUserRoles(User user) {
        return userDao.getUserRoles(user);
    }
}
