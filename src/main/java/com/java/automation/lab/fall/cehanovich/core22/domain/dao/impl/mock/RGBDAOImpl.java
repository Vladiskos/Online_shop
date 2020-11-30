package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RGBDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

import java.util.List;

public class RGBDAOImpl implements RGBDAO {
    private static RGBDAOImpl instance;

    public synchronized static RGBDAOImpl getInstance() {
        if (instance==null) {
            instance = new RGBDAOImpl();
        }
        return instance;
    }

    private RGBDAOImpl() {

    }

    @Override
    public synchronized RGB create(RGB rgb) {
        return rgb;
    }

    @Override
    public synchronized RGB update(RGB newRGB) {
        return new RGB(newRGB.getRed(), newRGB.getGreen(), newRGB.getBlue());
    }

    @Override
    public RGB getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<RGB> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
