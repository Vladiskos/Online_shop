package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.RGB;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.RGBDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
        new ObjectIO<RGB>().write(rgb, IOConstant.RQ_PATH);
        return rgb;
    }

    @Override
    public synchronized RGB update(RGB newRGB) {
        return new RGB(newRGB.getRed(), newRGB.getGreen(), newRGB.getBlue());
    }

    @Override
    public RGB getById(Long id) {
        return new ObjectIO<RGB>().read(IOConstant.RQ_PATH);
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
