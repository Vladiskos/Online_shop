package com.java.automation.lab.fall.cehanovich.core22.domain.service;

import com.java.automation.lab.fall.cehanovich.core22.domain.dao.*;
import com.java.automation.lab.fall.cehanovich.core22.domain.io.PropertyReader;

import java.util.Map;

public class BaseService {
    protected static final PropertyReader PROPS = PropertyReader.getInstance();

    protected static final Map<String, AddressDAO> ADDRESS_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.AddressDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.AddressDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.AddressDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.AddressDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.AddressDAOImpl.getInstance()
    );
    protected static final Map<String, BankCardDAO> BANK_CARD_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.BankCardDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.BankCardDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.BankCardDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.BankCardDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.BankCardDAOImpl.getInstance()
    );
    protected static final Map<String, BasketDAO> BASKET_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.BasketDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.BasketDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.BasketDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.BasketDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.BasketDAOImpl.getInstance()
    );
    protected static final Map<String, BillingInfoDAO> BILLING_INFO_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.BillingInfoDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.BillingInfoDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.BillingInfoDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.BillingInfoDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.BillingInfoDAOImpl.getInstance()
    );
    protected static final Map<String, CategoryDAO> CATEGORY_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.CategoryDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.CategoryDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.CategoryDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.CategoryDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.CategoryDAOImpl.getInstance()
    );
    protected static final Map<String, CouponDAO> COUPON_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.CouponDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.CouponDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.CouponDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.CouponDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.CouponDAOImpl.getInstance()
    );
    protected static final Map<String, OrderDAO> ORDER_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.OrderDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.OrderDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.OrderDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.OrderDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.OrderDAOImpl.getInstance()
    );
    protected static final Map<String, PriceBookDAO> PRICE_BOOK_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.PriceBookDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.PriceBookDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.PriceBookDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.PriceBookDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.PriceBookDAOImpl.getInstance()
    );
    protected static final Map<String, ProductDAO> PRODUCT_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.ProductDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.ProductDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.ProductDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.ProductDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.ProductDAOImpl.getInstance()
    );
    protected static final Map<String, RegisteredUserDAO> REGISTERED_USER_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.RegisteredUserDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.RegisteredUserDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.RegisteredUserDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.RegisteredUserDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.RegisteredUserDAOImpl.getInstance()
    );
    protected static final Map<String, RGBDAO> RGBDAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.RGBDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.RGBDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.RGBDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.RGBDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.RGBDAOImpl.getInstance()
    );
    protected static final Map<String, ShippingInfoDAO> SHIPPING_INFO_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.ShippingInfoDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.ShippingInfoDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.ShippingInfoDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.ShippingInfoDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.ShippingInfoDAOImpl.getInstance()
    );

    protected static final Map<String, SubcategoryDAO> SUBCATEGORY_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.SubcategoryDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.SubcategoryDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.SubcategoryDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.SubcategoryDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.SubcategoryDAOImpl.getInstance()
    );

    protected static final Map<String, UserDAO> USER_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.UserDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.UserDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.UserDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.UserDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.UserDAOImpl.getInstance()
    );

    protected static final Map<String, VariationDAO> VARIATION_DAO_MAP = Map.of(
            "MOCK", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.mock.VariationDAOImpl.getInstance(),
            "OBJ", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.clazz.VariationDAOImpl.getInstance(),
            "XML", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.xml.VariationDAOImpl.getInstance(),
            "JSON", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.json.VariationDAOImpl.getInstance(),
            "SQL", com.java.automation.lab.fall.cehanovich.core22.domain.dao.impl.sql.VariationDAOImpl.getInstance()
    );


}
