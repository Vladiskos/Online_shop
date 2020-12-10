package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.classes.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.constant.PropertyConstant;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.BasketDAO;
import com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.BasketDAOImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BasketService extends BaseService{
    private static final BasketDAO DAO = BASKET_DAO_MAP.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public static Basket createBasket(int id, List<Variation> variations, BigDecimal totalPrice, BankCard bankCard,
                                      PriceBook priceBook, Coupon coupon, User user, LocalDate created, LocalDate modified) {
        return DAO.create(new Basket(id, variations, totalPrice, bankCard, priceBook, coupon, user, created, modified));
    }

    public static Basket getBasketById(Long id) {
        return DAO.getById(id);
    }

    public static List<Basket> get() {
        return DAO.get();
    }

    public static Basket update(Basket o) {
        return DAO.update(o);
    }

    public static void deleteById(Long id) {
        DAO.deleteById(id);
    }
}
