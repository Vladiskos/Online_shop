package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.PriceBook;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.PriceBookDAO;

import java.util.List;

public class PriceBookDAOImpl implements PriceBookDAO {
    private static PriceBookDAOImpl instance;

    public synchronized static PriceBookDAOImpl getInstance() {
        if (instance==null) {
            instance = new PriceBookDAOImpl();
        }
        return instance;
    }

    private PriceBookDAOImpl() {

    }

    @Override
    public synchronized PriceBook create(PriceBook priceBook) {
        return priceBook;
    }

    @Override
    public synchronized PriceBook update(PriceBook newPriceBook) {
        return new PriceBook(newPriceBook.getCurrency(), newPriceBook.isEnabled(), newPriceBook.getValidFrom(),
                newPriceBook.getValidTo(), newPriceBook.getPriceAndProduct());
    }

    @Override
    public PriceBook getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<PriceBook> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
