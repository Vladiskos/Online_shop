package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RegisteredUser;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RegisteredUserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
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
    public RegisteredUser create(RegisteredUser o) {
        try {
            new XMLIO<>(RegisteredUser.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public RegisteredUser getById(Long id) {
        try {
            return new XMLIO<>(RegisteredUser.class).read(String.format(IOConstant.XML_OBJ_PATH,
                    RegisteredUser.class.getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RegisteredUser> get() {
        return null;
    }

    @Override
    public RegisteredUser update(RegisteredUser o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
