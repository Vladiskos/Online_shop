package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.User;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.UserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
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
    public User create(User o) {
        try {
            new JsonIO<>(User.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public User getById(Long id) {
        try {
            return new JsonIO<>(User.class).read(String.format(IOConstant.JSON_OBJ_PATH, User.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> get() {
        return null;
    }

    @Override
    public User update(User o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
