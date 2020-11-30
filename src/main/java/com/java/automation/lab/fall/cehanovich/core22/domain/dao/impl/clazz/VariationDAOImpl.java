package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Variation;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.VariationDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
    public synchronized Variation create(Variation variation) {
        new ObjectIO<Variation>().write(variation, IOConstant.RQ_PATH);
        return variation;
    }

    @Override
    public synchronized Variation update(Variation newVariation) {
        Variation updated = new Variation(newVariation.getId(), newVariation.getSize(), newVariation.getColor(),
                newVariation.getProduct(), newVariation.getDiscountPercent());
        return updated;
    }

    @Override
    public Variation getById(Long id) {
        return new ObjectIO<Variation>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Variation> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
