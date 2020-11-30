package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RegisteredUser;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RegisteredUserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

import java.util.List;

public class RegisteredUserDAOImpl implements RegisteredUserDAO {
    private static RegisteredUserDAOImpl instance;

    public synchronized static RegisteredUserDAOImpl getInstance() {
        if (instance==null) {
            instance = new RegisteredUserDAOImpl();
        }
        return instance;
    }

    private RegisteredUserDAOImpl() {

    }

    @Override
    public synchronized RegisteredUser create(RegisteredUser registeredUser) {
        return registeredUser;
    }

    @Override
    public synchronized RegisteredUser update(RegisteredUser newRegisteredUser) {
        return new RegisteredUser(newRegisteredUser.getId(), newRegisteredUser.getFirstname(),
                newRegisteredUser.getLastname(), newRegisteredUser.getContactNumber(), newRegisteredUser.getEmail(),
                newRegisteredUser.getSavedCards(), newRegisteredUser.getAddress(), newRegisteredUser.getDiscount(),
                newRegisteredUser.getBirthday());
    }

    @Override
    public RegisteredUser getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<RegisteredUser> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
