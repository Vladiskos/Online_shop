package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.UserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.UserDAOImpl;

import java.util.List;

public class UserService extends BaseService{
    private static final UserDAO DAO = USER_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static User createUser(int id, String firstname, String lastname, String contactNumber, String email) {
        return DAO.create(new User(id, firstname, lastname, contactNumber, email));
    }

    public static User getUserById(Long id) {
        return DAO.getById(id);
    }

    public static List<User> get() {
        return DAO.get();
    }

    public static User update(User o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
