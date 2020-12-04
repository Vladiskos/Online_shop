package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.ShippingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ShippingInfoDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
import java.util.List;

public class ShippingInfoDAOImpl implements ShippingInfoDAO {
    private static ShippingInfoDAOImpl instance;

    public synchronized static ShippingInfoDAOImpl getInstance() {
        if (instance==null) {
            instance = new ShippingInfoDAOImpl();
        }
        return instance;
    }

    private ShippingInfoDAOImpl() {

    }

    @Override
    public ShippingInfo create(ShippingInfo o) {
        try {
            new JsonIO<>(ShippingInfo.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public ShippingInfo getById(Long id) {
        try {
            return new JsonIO<>(ShippingInfo.class).read(String.format(IOConstant.JSON_OBJ_PATH, ShippingInfo.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ShippingInfo> get() {
        return null;
    }

    @Override
    public ShippingInfo update(ShippingInfo o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
