package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.AddressDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
    public synchronized Address create(Address address) {
        new ObjectIO<Address>().write(address, IOConstant.RQ_PATH);
        return address;
    }

    @Override
    public synchronized Address update(Address newAddress) {
        return new Address(newAddress.getCity(), newAddress.getStreet(), newAddress.getHouse(),
                newAddress.getApartment());
    }

    @Override
    public Address getById(Long id) {
        return new ObjectIO<Address>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Address> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
