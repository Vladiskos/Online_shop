package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RegisteredUserDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.RegisteredUserDAOImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class RegisteredUserService extends BaseService{
    private static final RegisteredUserDAO DAO = REGISTERED_USER_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static RegisteredUser createRegisteredUser(int id, String firstname, String lastname, String contactNumber,
                                                      String email, Set<BankCard> savedCards, Address address,
                                                      int discountPercent, LocalDate birthday) {
        return DAO.create(new RegisteredUser(
                id, firstname, lastname, contactNumber, email, savedCards, address, discountPercent, birthday));
    }

    public static RegisteredUser getRegisteredUserById(Long id) {
        return DAO.getById(id);
    }

    public static List<RegisteredUser> get() {
        return DAO.get();
    }

    public static RegisteredUser update(RegisteredUser o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
