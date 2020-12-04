package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Variation;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.VariationDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
import java.util.List;

public class VariationDAOImpl implements VariationDAO {
    private static VariationDAOImpl instance;

    public synchronized static VariationDAOImpl getInstance() {
        if (instance==null) {
            instance = new VariationDAOImpl();
        }
        return instance;
    }

    private VariationDAOImpl() {

    }

    @Override
    public Variation create(Variation o) {
        try {
            new JsonIO<>(Variation.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Variation getById(Long id) {
        try {
            return new JsonIO<>(Variation.class).read(String.format(IOConstant.JSON_OBJ_PATH, Variation.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Variation> get() {
        return null;
    }

    @Override
    public Variation update(Variation o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
