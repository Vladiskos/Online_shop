package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.Coupon;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.CouponDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.CouponDAOImpl;

import java.time.LocalDate;
import java.util.List;

public class CouponService extends BaseService{
    private static final CouponDAO DAO = COUPON_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public static Coupon createCoupon(int id, boolean enabled, int discountPercent, LocalDate created,
                                      LocalDate modified) {
        return DAO.create(new Coupon(id, enabled, discountPercent, created, modified));
    }

    public static Coupon getCouponById(Long id) {
        return DAO.getById(id);
    }

    public static List<Coupon> get() {
        return DAO.get();
    }

    public static Coupon update(Coupon o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
