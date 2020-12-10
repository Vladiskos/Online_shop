package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.ShippingInfoDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.ShippingInfoDAOImpl;
import com.java.automation.lab.fall.cehanovich.core22.domain.classes.info.ShippingInfo;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;

public class ShippingInfoService extends BaseService{
    private static final ShippingInfoDAO DAO = SHIPPING_INFO_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static ShippingInfo createShippingInfo(OffsetDateTime date, Address address, User customerInfo,
                                                  LocalDate created, LocalDate modified) {
        return DAO.create(new ShippingInfo(date, address, customerInfo, created, modified));
    }

    public static ShippingInfo getShippingInfoById(Long id) {
        return DAO.getById(id);
    }

    public static List<ShippingInfo> get() {
        return DAO.get();
    }

    public static ShippingInfo update(ShippingInfo o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
