package com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Coupon;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.IOConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CouponDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.exception.NotImplementedException;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.ObjectIO;

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
    public synchronized Coupon create(Coupon coupon) {
        new ObjectIO<Coupon>().write(coupon, IOConstant.RQ_PATH);
        return coupon;
    }

    @Override
    public synchronized Coupon update(Coupon newCoupon) {
        return new Coupon(newCoupon.getId(), newCoupon.isEnabled(), newCoupon.getDiscountPercent());
    }

    @Override
    public Coupon getById(Long id) {
        return new ObjectIO<Coupon>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Coupon> get() {
        throw new NotImplementedException("Method 'get' not implemented for " + this.getClass());
    }

    @Override
    public void deleteById(Long id) {
        throw new NotImplementedException("Method 'deleteById' not implemented for " + this.getClass());
    }
}
