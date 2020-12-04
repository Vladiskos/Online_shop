package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.BankCard;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BankCardDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
import java.util.List;

public class BankCardDAOImpl implements BankCardDAO {
    private static BankCardDAOImpl instance;

    public static synchronized BankCardDAOImpl getInstance() {
        if (instance==null) {
            instance = new BankCardDAOImpl();
            System.out.println();
        }
        return instance;
    }

    private BankCardDAOImpl() {

    }

    @Override
    public BankCard create(BankCard o) {
        try {
            new JsonIO<>(BankCard.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public BankCard getById(Long id) {
        try {
            return new JsonIO<>(BankCard.class).read(String.format(IOConstant.JSON_OBJ_PATH, BankCard.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BankCard> get() {
        return null;
    }

    @Override
    public BankCard update(BankCard o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
