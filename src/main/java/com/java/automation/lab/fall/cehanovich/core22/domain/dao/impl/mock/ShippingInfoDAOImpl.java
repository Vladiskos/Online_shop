package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ShippingInfoDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.ShippingInfo;

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
    public synchronized ShippingInfo create(ShippingInfo shippingInfo) {
        return shippingInfo;
    }

    @Override
    public synchronized ShippingInfo update(ShippingInfo newShippingInfo) {
        return new ShippingInfo(newShippingInfo.getDate(), newShippingInfo.getAddress(),
                newShippingInfo.getCustomerInfo());
    }

    @Override
    public ShippingInfo getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<ShippingInfo> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
