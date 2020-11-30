package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.BankCard;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BankCardDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
        new ObjectIO<BankCard>().write(bankCard, IOConstant.RQ_PATH);
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
        return new ObjectIO<BankCard>().read(IOConstant.RQ_PATH);
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
