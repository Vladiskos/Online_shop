package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RegisteredUser;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RegisteredUserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
        new ObjectIO<RegisteredUser>().write(registeredUser, IOConstant.RQ_PATH);
        return registeredUser;
    }

    @Override
    public synchronized RegisteredUser update(RegisteredUser newRegisteredUser) {
        return new RegisteredUser(newRegisteredUser.getId(), newRegisteredUser.getFirstname(),
                newRegisteredUser.getLastname(), newRegisteredUser.getContactNumber(), newRegisteredUser.getEmail(),
                newRegisteredUser.getSavedCards(), newRegisteredUser.getDiscountPercent(),
                newRegisteredUser.getBirthday(), newRegisteredUser.getSalt(), newRegisteredUser.getPasswordHash(),
                newRegisteredUser.getCreated(), newRegisteredUser.getModified(), newRegisteredUser.getRoleId());
    }

    @Override
    public RegisteredUser getById(Long id) {
        return new ObjectIO<RegisteredUser>().read(IOConstant.RQ_PATH);
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
