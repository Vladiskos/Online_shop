package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.BillingInfo;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BillingInfoDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
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
    public BillingInfo create(BillingInfo o) {
        try {
            new JsonIO<>(BillingInfo.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public BillingInfo getById(Long id) {
        try {
            return new JsonIO<>(BillingInfo.class).read(String.format(IOConstant.JSON_OBJ_PATH, BillingInfo.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BillingInfo> get() {
        return null;
    }

    @Override
    public BillingInfo update(BillingInfo o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
