package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BankCardDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

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
    public synchronized BankCard create(BankCard bankCard) {
        return bankCard;
    }

    @Override
    public synchronized BankCard update(BankCard newBankCard) {
        try {
            return new BankCard(newBankCard.getNumber(), newBankCard.getValidity(), newBankCard.getCvc(),
                    newBankCard.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BankCard getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<BankCard> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
