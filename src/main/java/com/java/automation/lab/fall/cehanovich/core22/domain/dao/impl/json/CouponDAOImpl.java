package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Address;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Coupon;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CouponDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.JsonIO;

import java.io.IOException;
import java.util.List;

public class CouponDAOImpl implements CouponDAO {
    private static CouponDAOImpl instance;

    public synchronized static CouponDAOImpl getInstance() {
        if (instance==null) {
            instance = new CouponDAOImpl();
        }
        return instance;
    }

    private CouponDAOImpl() {

    }

    @Override
    public Coupon create(Coupon o) {
        try {
            new JsonIO<>(Coupon.class).write(o, String.format(IOConstant.JSON_OBJ_PATH, o.getClass().getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return o;
    }

    @Override
    public Coupon getById(Long id) {
        try {
            return new JsonIO<>(Coupon.class).read(String.format(IOConstant.JSON_OBJ_PATH, Coupon.class.getCanonicalName()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Coupon> get() {
        return null;
    }

    @Override
    public Coupon update(Coupon o) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
    }
}
