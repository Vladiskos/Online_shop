package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.AddressDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.XMLIO;

import javax.xml.bind.JAXBException;
import java.util.List;

public class AddressDAOImpl implements AddressDAO {
    private static AddressDAOImpl instance;

    public static synchronized AddressDAOImpl getInstance() {
        if (instance==null) {
            instance = new AddressDAOImpl();
            System.out.println();
        }
        return instance;
    }

    private AddressDAOImpl() {

    }
    @Override
    public Address create(Address o) {
        try {
            new XMLIO<>(Address.class).write(o, String.format(IOConstant.XML_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Address getById(Long id) {
        try {
            return new XMLIO<>(Address.class).read(String.format(IOConstant.XML_OBJ_PATH, Address.class.getCanonicalName()));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Address> get() {
        return null;
    }

    @Override
    public Address update(Address o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
