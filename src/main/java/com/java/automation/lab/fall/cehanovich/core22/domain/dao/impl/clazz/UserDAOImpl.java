package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.User;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.UserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl instance;

    public synchronized static UserDAOImpl getInstance() {
        if (instance==null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    private UserDAOImpl() {

    }

    @Override
    public synchronized User create(User user) {
        new ObjectIO<User>().write(user, IOConstant.RQ_PATH);
        return user;
    }

    @Override
    public synchronized User update(User newUser) {
        return new User(newUser.getId(), newUser.getFirstname(), newUser.getLastname(),
                newUser.getContactNumber(), newUser.getEmail());
    }

    @Override
    public User getById(Long id) {
        return new ObjectIO<User>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<User> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
