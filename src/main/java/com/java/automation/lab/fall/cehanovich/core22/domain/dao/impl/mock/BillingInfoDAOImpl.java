package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.BillingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BillingInfoDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;

import java.util.List;

public class BillingInfoDAOImpl implements BillingInfoDAO {
    private static BillingInfoDAOImpl instance;

    public synchronized static BillingInfoDAOImpl getInstance() {
        if (instance==null) {
            instance = new BillingInfoDAOImpl();
        }
        return instance;
    }

    private BillingInfoDAOImpl() {

    }

    @Override
    public synchronized BillingInfo create(BillingInfo billingInfo) {
        return billingInfo;
    }

    @Override
    public synchronized BillingInfo update(BillingInfo newBillingInfo) {
        return new BillingInfo(newBillingInfo.getTotalPrice(), newBillingInfo.getPayment(),
                newBillingInfo.getInformation());
    }

    @Override
    public BillingInfo getById(Long id) {
        throw new NotImplementedException("Method 'getById' not implemented for " + this.getClass());
    }

    @Override
    public List<BillingInfo> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
