package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.UserDAO;

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
        return user;
    }

    @Override
    public synchronized User update(User newUser) {
        return new User(newUser.getId(), newUser.getFirstname(), newUser.getLastname(),
                newUser.getContactNumber(), newUser.getEmail());
    }

    @Override
    public User getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
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
