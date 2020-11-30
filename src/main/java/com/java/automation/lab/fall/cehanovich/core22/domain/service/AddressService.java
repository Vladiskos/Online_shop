package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.AddressDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.AddressDAOImpl;
import com.java.automation.lab.fall.cehanovich.core22.domain.enums.City;

import java.util.List;

public class AddressService extends BaseService{
    private static final AddressDAO DAO = ADDRESS_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static Address createAddress(City city, String street, int house, int apartment) {
        return DAO.create(new Address(city, street, house, apartment));
    }

    public static Address getAddressById(Long id) {
        return DAO.getById(id);
    }

    public static List<Address> get() {
        return DAO.get();
    }

    public static Address update(Address o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }

}
