package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.PriceBook;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.PriceBookDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
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
    public PriceBook create(PriceBook o) {
        try {
            new JsonIO<>(PriceBook.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public PriceBook getById(Long id) {
        try {
            return new JsonIO<>(PriceBook.class).read(String.format(IOConstant.JSON_OBJ_PATH, PriceBook.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PriceBook> get() {
        return null;
    }

    @Override
    public PriceBook update(PriceBook o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
